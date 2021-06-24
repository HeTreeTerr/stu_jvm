package com.hss.optional;

import com.hss.mybatis.pojo.User;

import java.util.Optional;

/**
 * 教程地址
 * https://mp.weixin.qq.com/s/QCGBS0gi25Gbp18Hwj7AFg
 */
public class StuOptional {

    private static User user = null;

    public static void main(String[] args) {

        StuOptional stuOptional = new StuOptional();

        /*
        Optional类
         Optional(T value)
         empty()
         of(T value)
         ofNullable(T value)
         */

//        stuOptional.testEmpty();

//        stuOptional.testOf();

//        stuOptional.testOfNullable();

        /*
        orElse(T other)，
        orElseGet(Supplier<? extends T> other)
        orElseThrow(Supplier<? extends X> exceptionSupplier)
         */

//        stuOptional.testOrElse();

//        stuOptional.testOrElseGet();

//        stuOptional.testOrElseThrow();

        /*
        map(Function<? super T, ? extends U> mapper)
        flatMap(Function<? super T, Optional<U>> mapper)
         */

//        stuOptional.testMap();

//        stuOptional.testFlatMap();

        /*
        isPresent()
        ifPresent(Consumer<? super T> consumer)
         */

//        stuOptional.testIsPresent();

//        stuOptional.testIfPresent();

        /**
         * filter(Predicate<? super T> predicate)
         */

        stuOptional.testFilter();
    }

    /**
     * 根据一定的条件来筛选
     */
    private void testFilter(){
        user = new User();
        user.setId(2);
        user.setAge(7);
        user.setName("李二狗");
        Optional<User> userOpt = Optional.ofNullable(StuOptional.user)
                .filter(u -> {
            return StuOptional.user.getAge() > 6;
        });
        System.out.println(userOpt.isPresent());
    }

    /**
     * 判断对象是否为空
     *  如果存在，执行一些方法
     */
    private void testIfPresent(){
//        User user = new User();
        Optional.ofNullable(user).ifPresent(user1 -> {
            System.out.println("do someThing!");
        });
    }

    /**
     * 判断对象是否为空
     */
    private void testIsPresent(){
//        User user = new User();
        boolean present = Optional.ofNullable(user).isPresent();
        System.out.println(present);
    }

    /**
     * 获取实体Optional<T>类型的方法的属性值
     * user==null || user.name==null
     *  java.util.NoSuchElementException: No value present
     * user.name != null
     *  获得 user.name的值
     */
    private void testFlatMap(){
        /*user = new User();
        user.setId(2);
        user.setAge(16);
        user.setName("李二狗");*/
        String name = Optional.ofNullable(user).flatMap(u -> u.getOptName()).get();
        System.out.println(name);
    }

    /**
     * 获取实体方法中的属性值
     * user==null || user.name==null
     *  java.util.NoSuchElementException: No value present
     * user.name != null
     *  获得 user.name的值
     */
    private void testMap(){
        /*user = new User();
        user.setId(2);
        user.setAge(16);
        user.setName("李二狗");*/
        String name = Optional.ofNullable(user).map(u -> u.getName()).get();
        System.out.println(name);
    }

    /**
     * 当user为空时，抛出异常
     */
    private void testOrElseThrow(){
        /*user = new User();
        user.setId(2);
        user.setAge(16);
        user.setName("李二狗");*/
        user = Optional.ofNullable(user)
                .orElseThrow(() -> new RuntimeException("运行时异常！"));
        System.out.println(user);
    }

    /**
     * 当user为空时，调用createUser()
     * 当user不为空时，不调用createUser()
     */
    private void testOrElseGet(){
        /*user = new User();
        user.setId(2);
        user.setAge(16);
        user.setName("李二狗");*/
        user = Optional.ofNullable(user).orElseGet(()-> createUser());
        System.out.println(user);
    }

    /**
     * 当user为空时，调用createUser()
     * 当user不为空时，同样调用createUser()
     */
    private void testOrElse(){
        /*user = new User();
        user.setId(2);
        user.setAge(16);
        user.setName("李二狗");*/

        user = Optional.ofNullable(user).orElse(createUser());
        System.out.println(user);
    }

    /**
     * 相比较of(T value)的区别就是:
     *  当value值为null时，of(T value)会报NullPointerException异常；
     *  ofNullable(T value)不会throw Exception，ofNullable(T value)直接返回一个EMPTY对象。
     */
    private void testOfNullable(){
        //createUser();
        Optional<User> userOpt = Optional.ofNullable(user);
        System.out.println("present=" + userOpt.isPresent());
        System.out.println("user=" + userOpt.get());
    }

    /**
     * 返回空对象
     * 调用get返回 java.util.NoSuchElementException: No value present
     */
    private void testEmpty(){
        createUser();
        Optional<User> userOpt = Optional.empty();
        System.out.println("present=" + userOpt.isPresent());
        System.out.println("user=" + userOpt.get());
    }

    /**
     * user = null
     *  java.lang.NullPointerException
     * user != null
     *  正常构造Optional对象
     */
    private void testOf(){
        //createUser();
        Optional<User> userOpt = Optional.of(user);
        System.out.println("present" + userOpt.isPresent());
        System.out.println("user=" + userOpt.get());
    }


    /**
     * 创建用户对象
     * @return
     */
    private User createUser(){
        System.out.println("-------method createUser is run------");
        user = new User();
        user.setId(1);
        user.setAge(18);
        user.setName("李盖伦");
        return user;
    }
}
