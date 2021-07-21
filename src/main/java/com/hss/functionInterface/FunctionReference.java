package com.hss.functionInterface;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionReference {

    public static void main(String[] args) {
        FunctionReference funReference = new FunctionReference();

//        funReference.funReference();

//        funReference.constructorReference();

        funReference.arrayReference();
    }

//    方法引用
    public void funReference(){
        Consumer<String> con = e -> System.out.println(e);
        con.accept("tom");
//        1.对象::实例方法名
        Consumer<String> con2 = System.out::println;
        con2.accept("tom");

        BiFunction<Integer,Integer,Integer> biFun = (x,y) -> Integer.compare(x,y);
        System.out.println(biFun.apply(1,2));
//        2.类名::静态方法名
        BiFunction<Integer,Integer,Integer> biFun1 = Integer::compareTo;
        System.out.println(biFun.apply(1,2));

        BiFunction<String,String,Boolean> biFunction = (x,y) -> x.equals(y);
        System.out.println(biFunction.apply("aaa","bbb"));
//        3.类名::实例方法名
        BiFunction<String,String,Boolean> biFunction1 = String::equals;
        System.out.println(biFunction1.apply("aaa","bbb"));
    }

//    构造器引用
    public void constructorReference(){
        Supplier<Emp> sup = () -> new Emp();
        System.out.println(sup.get());
//        构造器引用 类名::new
        Supplier<Emp> sup1 = Emp::new;
        System.out.println(sup1.get());

//        构造器引用 类名::new(构造器带参数)
        BiFunction<Long,String,Emp> biFun = Emp::new;
        System.out.println(biFun.apply(1L,"hss"));
    }

//    数组引用
    public void arrayReference(){
        Function<Integer,String[]> fun = e -> new String[e];
        //数组引用 Type[]::new
        Function<Integer,String[]> fun1 = String[]::new;
        String[] strings = fun1.apply(10);
        strings[0] = "0";
        strings[1] = "1";
        Arrays.stream(strings).forEach(
                System.out::println
        );

    }
}
