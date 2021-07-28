package com.hss.collection.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {

    public static void main(String[] args) {
        StreamApi streamApi = new StreamApi();
//        streamApi.beginStream();

//        streamApi.appendStream();

//        streamApi.endStream();

        streamApi.parallelAndsequential();
    }

    //创建
    public void beginStream(){
        String[] strs = {"aaa", "bbb", "ccc", "ddd"};
        //1.通过Collection系列集合提供的stream()或者paralleStream()
        List<String> list = Arrays.asList(strs);
        Stream<String> stream1 = list.stream();
        System.out.println(stream1);

        //2.通过Arrays的静态方法stream()获取数组流
        Stream<String> stream2 = Arrays.stream(strs);
        System.out.println(stream2);

        //3.通过Stream类中的静态方法of
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");
        System.out.println(stream3);

        //4.创建无限流
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        System.out.println(stream4);

        //生成
        Stream<Double> stream5 = Stream.generate(() -> Math.random());
        System.out.println(stream5);
    }

    //应用
    public void appendStream(){
        ArrayList<Emp> emps = new ArrayList<>();
        emps.add(new Emp("AA",15));
        emps.add(new Emp("BB",43));
        emps.add(new Emp("CC",25));
        emps.add(new Emp("DD",9));
        /**
         * 筛选 过滤  去重
         */
        System.out.println("-----------------------");
        emps.stream()
                //获取年龄大于10的集合
                .filter(e -> e.getAge() > 10)
                //取前两个元素
                .limit(2)
                //跳过第一个元素
                .skip(1)
                // 需要流中的元素重写hashCode和equals方法
                .distinct()
                .forEach(System.out::println);

        /**
         * 生成新的流 通过map映射
         */
        System.out.println("-----------------------");
        emps.stream()
                .map(e -> e.getAge())
                .forEach(System.out::println);

        /**
         * 排序
         */
        System.out.println("-----------------------");
        emps.stream()
                .sorted((e1,e2) -> {
                    if (e1.getAge().equals(e2.getAge())){
                        return e1.getName().compareTo(e2.getName());
                    }else{
                        return e1.getAge().compareTo(e2.getAge());
                    }
                })
                .forEach(e -> {
                    System.out.println(e);
                });
    }

    //终止
    public void endStream(){
        ArrayList<Emp> emps = new ArrayList<>();
        emps.add(new Emp("AA",15));
        emps.add(new Emp("BB",43));
        emps.add(new Emp("CC",25));
        emps.add(new Emp("DD",9));

        /**
         *      查找和匹配
         *          allMatch-检查是否匹配所有元素
         *          anyMatch-检查是否至少匹配一个元素
         *          noneMatch-检查是否没有匹配所有元素
         *          findFirst-返回第一个元素
         *          findAny-返回当前流中的任意元素
         *          count-返回流中元素的总个数
         *          max-返回流中最大值
         *          min-返回流中最小值
         */

        //检查是否匹配所有元素
        System.out.println("-----------------------");
        boolean allMatch = emps.stream()
                .allMatch(e -> e.getAge().equals(15));
        System.out.println(allMatch);

        //检查是否至少匹配一个元素
        System.out.println("-----------------------");
        boolean anyMatch = emps.stream()
                .anyMatch(e -> e.getAge().equals(15));
        System.out.println(anyMatch);

        //检查是否没有匹配所有元素
        System.out.println("-----------------------");
        boolean noneMatch = emps.stream()
                .noneMatch(e -> e.getAge().equals(8));
        System.out.println(noneMatch);

        //返回第一个元素
        System.out.println("-----------------------");
        Optional<Emp> first = emps.stream()
                .findFirst();
        System.out.println(first.get());

        //返回当前流中的任意元素(有疑点)
        System.out.println("-----------------------");
        Optional<Emp> findAny = emps.stream()
                .findAny();
        System.out.println(findAny.get());

        //返回流中元素的总个数
        System.out.println("-----------------------");
        long count = emps.stream()
                .count();
        System.out.println(count);

        //返回流中最大值
        System.out.println("-----------------------");
        Optional<Emp> max = emps.stream()
                .max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println(max.get());

        //返回流中最小值
        System.out.println("-----------------------");
        Optional<Emp> min = emps.stream()
                .min((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println(min.get());

        //从stream流中获取新的list结果集
        System.out.println("-----------------------");
        List<Integer> ages = emps.stream()
                .map(e -> e.getAge())
                .collect(Collectors.toList());

        ages.stream()
                .forEach(System.out::println);

        //可以将流中元素反复结合起来，得到一个值
        Optional<Integer> reduce = emps.stream()
                .map(e -> e.getAge())
                .reduce(Integer::sum);
        System.out.println(reduce.get());
    }

    public void parallelAndsequential(){
//        定义列表
        List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        串行流（默认）
        System.out.println("---------串行流--------");
        asList.stream()
                .forEach(System.out::println);
//        并行流
        System.out.println("---------并行流--------");
        asList.parallelStream()
                .forEach(System.out::println);
//        串行转并行
        System.out.println("---------串行转并行--------");
        asList.stream()
                .parallel()
                .forEach(System.out::println);
//        并行转串行
        System.out.println("---------并行转串行--------");
        asList.parallelStream()
                .sequential()
                .forEach(System.out::println);
    }
}
