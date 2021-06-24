package com.hss.optional;

import com.hss.bean.Address;
import com.hss.bean.Worker;

/**
 * 实用教程
 */
public class OptionalApply {

    public static void main(String[] args) {

        OptionalApply optionalApply = new OptionalApply();

        Worker worker = new Worker("张三",6);
        Address address = new Address("xx省","xx市","xx县");
        worker.setAddress(address);

        optionalApply.testGetCityOld(worker);

        optionalApply.testGetCityNew(worker);
    }

    /**
     * 以前的写法
     * @return
     */
    private String testGetCityOld(Worker worker){
        if(worker != null){
            if(worker.getAddress() != null){
                Address address = worker.getAddress();
                /*if(){

                }*/
            }
        }
        throw new RuntimeException("取值错误");
    }

    /**
     * 现在的写法
     * @return
     */
    private String testGetCityNew(Worker worker){

        return null;
    }
}
