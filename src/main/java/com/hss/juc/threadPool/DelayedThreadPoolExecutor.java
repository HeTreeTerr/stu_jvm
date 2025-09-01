package com.hss.juc.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Objects;

/**
 * <p>
 *  延迟任务线程池
 * </p>
 *
 * @author Hss
 * @date 2025-09-01
 */
public class DelayedThreadPoolExecutor {

    /**
     * 延迟任务包装类
     * @param <V>
     */
    private static class DelayedTask<V> implements Delayed, Runnable {
        private final Callable<V> task;
        private final Runnable runnableTask;
        private final long triggerTime; // 纳秒单位的触发时间
        private final long sequenceNumber;
        private final CompletableFuture<V> future;
        private static final AtomicLong sequencer = new AtomicLong(0);

        /**
         * 基于Callable任务的构造函数
         */
        public DelayedTask(Callable<V> task, long delay, TimeUnit unit) {
            this.task = Objects.requireNonNull(task);
            this.runnableTask = null;
            this.triggerTime = System.nanoTime() + unit.toNanos(delay);
            this.sequenceNumber = sequencer.getAndIncrement();
            this.future = new CompletableFuture<>();
        }

        /**
         * 基于Runnable任务的构造函数
         */
        public DelayedTask(Runnable task, long delay, TimeUnit unit) {
            this.task = null;
            this.runnableTask = Objects.requireNonNull(task);
            this.triggerTime = System.nanoTime() + unit.toNanos(delay);
            this.sequenceNumber = sequencer.getAndIncrement();
            this.future = new CompletableFuture<>();
            // 对于Runnable任务，返回null作为结果
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(triggerTime - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            if (other == this) {return 0;}

            if (other instanceof DelayedTask) {
                DelayedTask<?> x = (DelayedTask<?>) other;
                long diff = triggerTime - x.triggerTime;
                if (diff < 0) {return -1;}
                else if (diff > 0) {return 1;}
                else if (sequenceNumber < x.sequenceNumber) {return -1;}
                else {return 1;}
            }

            long diff = getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS);
            return (diff < 0) ? -1 : (diff > 0) ? 1 : 0;
        }

        @Override
        public void run() {
            // 如果任务已被取消，则不执行
            if (future.isCancelled()) {
                return;
            }

            try {
                if (task != null) {
                    V result = task.call();
                    future.complete(result);
                } else {
                    runnableTask.run();
                    future.complete(null); // Runnable任务返回null
                }
            } catch (Exception e) {
                future.completeExceptionally(e);
            }
        }

        public CompletableFuture<V> getFuture() {
            return future;
        }
    }

    private final ExecutorService workerPool;
    private final DelayQueue<DelayedTask<?>> delayQueue;
    private final Thread queueConsumerThread;
    private volatile boolean isShutdown = false;

    /**
     * 创建延迟线程池
     * @param corePoolSize 核心线程数
     * @param maximumPoolSize 临时线程数
     */
    public DelayedThreadPoolExecutor(int corePoolSize, int maximumPoolSize) {
        this(corePoolSize, maximumPoolSize, Executors.defaultThreadFactory());
    }

    /**
     * 创建延迟线程池（使用自定义线程工厂）
     * @param corePoolSize 核心线程数
     * @param maximumPoolSize 临时线程数
     * @param threadFactory 线程工厂
     */
    public DelayedThreadPoolExecutor(int corePoolSize, int maximumPoolSize, ThreadFactory threadFactory) {
        if (corePoolSize <= 0) {
            throw new IllegalArgumentException("Core pool size must be positive");
        }

        this.workerPool = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(500),
                threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        this.delayQueue = new DelayQueue<>();

        // 启动队列消费线程
        this.queueConsumerThread = threadFactory.newThread(this::consumeDelayedTasks);
        this.queueConsumerThread.setName("DelayedTask-Consumer");
        this.queueConsumerThread.start();
    }

    /**
     * 提交延迟任务（Callable版本）
     * @param task 要执行的任务
     * @param delay 延迟时间
     * @param unit 时间单位
     * @return CompletableFuture对象，可用于获取执行结果或取消任务
     */
    public <V> CompletableFuture<V> submit(Callable<V> task, long delay, TimeUnit unit) {
        if (isShutdown) {
            throw new RejectedExecutionException("Executor has been shut down");
        }

        Objects.requireNonNull(task);
        if (delay < 0) {
            throw new IllegalArgumentException("Delay must be non-negative");
        }

        DelayedTask<V> delayedTask = new DelayedTask<>(task, delay, unit);
        delayQueue.put(delayedTask);
        return delayedTask.getFuture();
    }

    /**
     * 提交延迟任务（Runnable版本）
     * @param task 要执行的任务
     * @param delay 延迟时间
     * @param unit 时间单位
     * @return CompletableFuture对象，可用于获取执行结果或取消任务
     */
    public CompletableFuture<Void> submit(Runnable task, long delay, TimeUnit unit) {
        if (isShutdown) {
            throw new RejectedExecutionException("Executor has been shut down");
        }

        Objects.requireNonNull(task);
        if (delay < 0) {
            throw new IllegalArgumentException("Delay must be non-negative");
        }

        DelayedTask<Void> delayedTask = new DelayedTask<>(task, delay, unit);
        delayQueue.put(delayedTask);
        return delayedTask.getFuture();
    }

    /**
     * 消费延迟队列中的任务
     */
    private void consumeDelayedTasks() {
        while (!isShutdown || !delayQueue.isEmpty()) {
            try {
                DelayedTask<?> task = delayQueue.take();
                workerPool.execute(task);
            } catch (InterruptedException e) {
                if (isShutdown) {
                    break;
                }
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * 优雅关闭线程池
     * 不再接受新任务，但会执行已提交的任务
     */
    public void shutdown() {
        isShutdown = true;
        queueConsumerThread.interrupt();
        workerPool.shutdown();
    }

    /**
     * 立即关闭线程池
     * 尝试停止所有正在执行的任务，暂停处理等待的任务
     * @return 从未开始执行的任务列表
     */
    public List<Runnable> shutdownNow() {
        isShutdown = true;
        queueConsumerThread.interrupt();
        workerPool.shutdownNow();

        // 获取队列中未执行的任务
        List<Runnable> notExecutedTasks = new ArrayList<>();
        DelayedTask<?> task;
        while ((task = delayQueue.poll()) != null) {
            task.getFuture().cancel(false);
            notExecutedTasks.add(task);
        }

        return notExecutedTasks;
    }

    /**
     * 等待线程池终止
     * @param timeout 超时时间
     * @param unit 时间单位
     * @return true如果线程池已终止，false如果超时
     */
    public boolean awaitTermination(long timeout, TimeUnit unit)
            throws InterruptedException {
        return workerPool.awaitTermination(timeout, unit);
    }

    /**
     * 检查线程池是否已关闭
     */
    public boolean isShutdown() {
        return isShutdown;
    }

    /**
     * 检查线程池是否已完全终止
     */
    public boolean isTerminated() {
        return workerPool.isTerminated();
    }

    /**
     * 使用示例
     */
    public static void main(String[] args) {
        DelayedThreadPoolExecutor executor = new DelayedThreadPoolExecutor(3,3);

        System.out.println("开始提交延迟任务: " + System.currentTimeMillis());

        // 提交多个不同延迟时间的任务
        executor.submit(() -> {
            System.out.println("任务1执行时间: " + System.currentTimeMillis() + " - 延迟2秒");
        }, 2, TimeUnit.SECONDS);

        executor.submit(() -> {
            System.out.println("任务2执行时间: " + System.currentTimeMillis() + " - 延迟1秒");
            return "任务2结果";
        }, 1, TimeUnit.SECONDS);

        executor.submit(() -> {
            System.out.println("任务3执行时间: " + System.currentTimeMillis() + " - 延迟3秒");
        }, 3, TimeUnit.SECONDS);

        executor.submit(() -> {
            System.out.println("任务4执行时间: " + System.currentTimeMillis() + " - 延迟500毫秒");
        }, 500, TimeUnit.MILLISECONDS);

        // 等待所有任务完成
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        System.out.println("线程池已关闭");
    }
}
