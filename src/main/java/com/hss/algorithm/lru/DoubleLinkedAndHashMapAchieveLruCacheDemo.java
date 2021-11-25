package com.hss.algorithm.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 手写lru算法
 * 双向链表+hashMap
 */
public class DoubleLinkedAndHashMapAchieveLruCacheDemo {

    /**
     * 定义node节点，所谓数据的载体
     * @param <T>
     * @param <S>
     */
    class Node<T,S>{
        T k;
        S v;
        Node prev;
        Node next;
//        无参构造器
        Node(){
            this.prev = this.next = null;
        }
//        有参构造器
        Node(T k,S v){
            this.k = k;
            this.v = v;
            this.prev = this.next = null;
        }
    }

    /**
     * 双向链表
     */
    class DoubleLinkedList<T,S>{
        Node<T,S> head;
        Node<T,S> tail;
        DoubleLinkedList(){
            head = new Node<T,S>();
            tail = new Node<T,S>();
            head.next = tail;
            tail.prev = head;
        }
//        添加到头
        public void addHead(Node<T,S> node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
//        删除节点
        public void removeNode(Node<T,S> node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }
//        获取最后一个节点
        public Node<T,S> getLastNode(){
            return tail.prev;
        }
    }

    int capacity;
    Map<String,Node<String,Object>> map;
    DoubleLinkedList<String,Object> linkedList;

    public DoubleLinkedAndHashMapAchieveLruCacheDemo(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.linkedList = new DoubleLinkedList<>();
    }

    public void put(String k,Object v){
        if(map.containsKey(k))
        {
//            更新
            Node<String, Object> node = map.get(k);
            node.v = v;
            linkedList.removeNode(node);
            linkedList.addHead(node);
        }else{
//            校验坑位
            if(map.size() >= capacity){
                Node<String, Object> lastNode = linkedList.getLastNode();
                linkedList.removeNode(lastNode);
                map.remove(lastNode.k);
            }
//            放入坑位
            Node<String, Object> newNode = new Node<>(k, v);
            linkedList.addHead(newNode);
            map.put(k,newNode);
        }
    }

    public Object get(String k){
        if(!map.containsKey(k)){
            return -1;
        }
        Node<String, Object> node = map.get(k);
        linkedList.removeNode(node);
        linkedList.addHead(node);
        return node.v;
    }

    public static void main(String[] args) {
        DoubleLinkedAndHashMapAchieveLruCacheDemo lruCacheDemo = new DoubleLinkedAndHashMapAchieveLruCacheDemo(3);
//        1.空间充足时，按照顺序入队
        lruCacheDemo.put("1","a");
        lruCacheDemo.put("2","b");
        lruCacheDemo.put("3","c");
        System.out.println(lruCacheDemo.map.keySet());
//        2.当key被操作后（get/put），热度变高
        lruCacheDemo.get("1");
        lruCacheDemo.put("2","b");
        System.out.println(lruCacheDemo.map.keySet());
//        3.当位置不够时，删除热度最低的键，再将新的键入队
        lruCacheDemo.put("4","d");
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put("5","e");
        System.out.println(lruCacheDemo.map.keySet());
    }
}
