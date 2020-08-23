package com.hss.generic;

/**
 * 泛型接口
 * 语法：接口名<T>
 * 注意：不能创建静态常量
 * @param <T>
 */
public interface MyGenericInterface<T> {

    T server(T t);
}
