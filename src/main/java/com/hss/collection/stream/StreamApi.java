package com.hss.collection.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamApi {

    public static void main(String[] args) {
        StreamApi streamApi = new StreamApi();
        streamApi.beginStream();
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

    }

    //终止
    public void endStream(){

    }
}
