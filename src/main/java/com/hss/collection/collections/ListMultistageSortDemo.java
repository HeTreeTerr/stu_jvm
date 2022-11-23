package com.hss.collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现list 自定义多级排序
 */
public class ListMultistageSortDemo {

    public static void main(String[] args) {
        //定义元素
        ListMultistageSortDemo sortDemo = new ListMultistageSortDemo();
        ListMultistageSortDemo.User user1 = sortDemo.new User(345L,"z3",44);
        ListMultistageSortDemo.User user2 = sortDemo.new User(657L,"l4",44);
        ListMultistageSortDemo.User user3 = sortDemo.new User(425L,"w5",18);
        ListMultistageSortDemo.User user4 = sortDemo.new User(222L,"w5",44);

        //创建集合并赋值
        List<ListMultistageSortDemo.User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        //=========Collections.sort=======
        /*//排序器（按age逆序）
        Comparator byAge = Comparator.comparing(ListMultistageSortDemo.User::getAge,Comparator.nullsFirst(Comparator.naturalOrder())).reversed();
        //排序器（按id正序）
        Comparator byId = Comparator.comparing(ListMultistageSortDemo.User::getId,Comparator.nullsFirst(Comparator.naturalOrder()));
        Collections.sort(list,byAge.thenComparing(byId));

        System.out.println("list=" + list);*/

        //===========stream=========
        List<User> list1 = list.stream()
                .sorted(
                        Comparator.comparing(ListMultistageSortDemo.User::getAge, Comparator.nullsFirst(Comparator.naturalOrder())).reversed()
                                .thenComparing(ListMultistageSortDemo.User::getId, Comparator.nullsFirst(Comparator.naturalOrder()))
                )
                .collect(Collectors.toList());

        System.out.println("list=" + list1);
    }

    /**
     * 内部类
     */
    public class User{

        private Long id;

        private String name;

        private Integer age;

        public User() {
        }

        public User(Long id, String name, Integer age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
