package com.hss.generic;

public class MyGenericInterfaceImpl<T> implements MyGenericInterface<T>{

    @Override
    public T server(T t) {
        if(t instanceof Integer){
            System.out.println("Integer");
        }else if(t instanceof String){
            System.out.println("String");
        }
        return t;
    }
}

