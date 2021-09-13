# 1.java深入学习
## 1.1 java基础
### 1.1.1 com.hss.collection
java集合使用
1. Vector
2. ArrayList
3. LinkedList

### 1.1.2 com.hss.map
java map使用
1. HashMap
2. LinkedHaskMap
3. TreeMap
4. Hashtable
5. ConcurrentHashMap

### 1.1.3 com.hss.set
java set使用
1. HashSet
2. TreeSet

### 1.1.4 com.hss.clone
java 对象拷贝
1. 浅拷贝
2. 深拷贝

### 1.1.5 com.hss.bigDecimal
BigDecimal基本方法调用，并用作金额计算

### 1.1.6 com.hss.functionInterface
* 函数式接口（jdk1.8新特性）
* lambda表达式（jdk1.8新特性）
* 方法引用（jdk1.8新特性）

### 1.1.7 com.hss.generic
泛型

### 1.1.8 com.hss.optional
optional容器（jdk1.8新特性）

### 1.1.9 com.hss.reflection
反射

### 1.1.10 com.hss.stuLocalDate
LocalDateTime（jdk1.8新特性）

### 1.1.11 com.hss.stuDefault
default（jdk1.8新特性）

## 1.2 jvm
### 1.2.1 com.hss.demo1
待补齐...

### 1.2.2 com.hss.demo2
待补齐...

## 1.3 高并发编程
### 1.3.1 com.hss.thread
java线程基本使用，线程的三种实现方式：
1. extends Thread
2. implements Runnable
3. implements Callable

### 1.3.2 com.hss.volatileStu
java volatile关键字特性学习。volatile是java虚拟级提供的轻量级
同步机制。
* 保证可见性
* 不保证原子性
* 禁止指令重新编排

### 1.3.3 com.hss.cas
CAS是什么？
* compareAndSwap，比较和交换
* 底层使用sun.misc.Unsafe

CAS的缺点？
* ABA问题
* 自旋锁消耗cpu
* 多变量共享一直行问题

**ABA问题简述**：  
线程t1，将变量又A变为B，又将B变成A；  
线程t2，使用A为预期量，CAS检查时判定没有发生改变；  
可能会造成数据的缺失。；  

解决方法：
 * CAS还是类似于乐观锁，同数据乐观锁的方式给它加一个
 * 版本号或者时间戳。
 * 如AtomicStampedReference
 
**自旋消耗cpu**：  
CAS核心实现是获取值A作为预期值，满足预期更新值；  
不满足，通过while重复尝试；  
如果重复尝试，一直不能满足预期值，则会一直占用cpu；

解决方法：  
破坏掉for死循环，当超过一定时间或者一定次数时
，return退出。JDK8新增的LongAddr（和ConcurrentHashMap类似的方法）。
当多个线程竞争时，将粒度变小，将一个变量拆分为多个变量，达到多个线程访问
多个资源的效果，最后再调用sum把它合起来。

**多变量共享一致性**：  
解决方法：  
使用锁；  
或者将多个共享变量合封装成一个对象来保证原子性(AtomicRefrence)；