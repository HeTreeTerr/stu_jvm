package com.hss.oop.overload;

/**
 * 人口登记
 * oop之重载
 */
public class PopulationRegister {

    /**
     * 获取人口信息
     * @param cardNo
     */
    public void getPopulationInfo(String cardNo){
        System.out.println("获取人口信息--cardNo");
    }

    /**
     * 获取人后信息
     * @param name
     * @param age
     * @param areaCode
     */
    public void getPopulationInfo(String name,String age,String areaCode){
        System.out.println("获取人口信息--name--age--areaCode");
    }

    public static void main(String[] args) {
        PopulationRegister populationRegister = new PopulationRegister();

        populationRegister.getPopulationInfo("sijdi478326482374872");

        populationRegister.getPopulationInfo("张三","18","4854565");
        /*
        执行结果：
        获取人口信息--cardNo
        获取人口信息--name--age--areaCode
         */
    }
}
