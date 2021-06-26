package com.hss.optional;

import com.hss.bean.Address;
import com.hss.bean.Worker;

import java.util.Optional;

/**
 * 实用教程
 */
public class OptionalApply {

    public static void main(String[] args) {

        OptionalApply optionalApply = new OptionalApply();

        Worker worker = null;

//        Worker worker = new Worker("张三",6);

//        Address address = new Address("xx省","xx市","xx县");
//        worker.setAddress(address);

//        System.out.println(optionalApply.testGetCityOld(worker));

//        System.out.println(optionalApply.testGetCityNew(worker));

//        optionalApply.testNotNullDoSomethingOld(worker);

//        optionalApply.testNotNullDoSomethingNew(worker);

//        System.out.println(optionalApply.testGetAddressOld(worker));

        System.out.println(optionalApply.testGetAddressNew(worker));
    }

    /**
     * 获取worker.address.city
     * 以前的写法
     * @return
     */
    private String testGetCityOld(Worker worker){
        if(worker != null){
            if(worker.getAddress() != null){
                Address address = worker.getAddress();
                if(null != address){
                    return address.getCity();
                }
            }
        }
        throw new RuntimeException("取值错误！");
    }

    /**
     * 获取worker.address.city
     * 现在的写法
     * @return
     */
    private String testGetCityNew(Worker worker){
        String city = Optional.ofNullable(worker)
                .map(w -> w.getAddress())
                .map(a -> a.getCity())
                .orElseThrow(() -> {
                    return new RuntimeException("取值错误！");
                });
        return city;
    }

    /**
     * 如果worker != null 执行something()
     * 以前的写法
     */
    private void testNotNullDoSomethingOld(Worker worker){
        if(null != worker){
            someThing();
        }
    }

    /**
     * 如果worker != null 执行something()
     * 现在的写法
     */
    private void testNotNullDoSomethingNew(Worker worker){
        Optional.ofNullable(worker)
                .ifPresent(w -> someThing());
    }

    /**
     * 获取地址信息
     * 以前的写法
     * @param worker
     * @return
     */
    private Address testGetAddressOld(Worker worker){
        if(null != worker){
            if(null != worker.getAddress()){
                return worker.getAddress();
            }
        }
        return createDefaultAddress();
    }

    /**
     * 获取地址信息
     * 现在的写法
     * @param worker
     * @return
     */
    private Address testGetAddressNew(Worker worker){
        Address address = Optional.ofNullable(worker)
                .map(w -> w.getAddress())
                .orElseGet(() -> createDefaultAddress());
        return address;
    }


    /**
     * to do someThing...
     */
    private void someThing(){
        System.out.println("to do someThing...");
    }

    /**
     * 新建默认的地址
     * @return
     */
    private Address createDefaultAddress(){
        return new Address("--省","--市","--县");
    }
}
