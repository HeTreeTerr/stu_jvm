package com.hss.functionInterface;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionInterface {

    public static void main(String[] args) {
        FunctionInterface funInterface = new FunctionInterface();

        funInterface.changeStr("consumer", e -> {
            System.out.println(e);
        });

        System.out.println(
                funInterface.getValue(() -> {
                    return "supplier";
                })
        );

        System.out.println(
                funInterface.changeNum("func",e ->{
                    return e + "tion";
                })
        );

        System.out.println(
                funInterface.judge(18,i -> {
                    return i < 20;
                })
        );
    }

    /**
     * Consumer<T> 消费型接口，有参数无返回
     * @param str
     * @param con
     */
    public void changeStr(String str, Consumer<String> con){
        con.accept(str);
    }

    /**
     * Supplier<T> 供给型接口，无参数有返回值
     * @param sup
     * @return
     */
    public String getValue(Supplier<String> sup){
        return sup.get();
    }

    /**
     * Function<T,R> 函数式接口，有参数有返回值
     * @param str
     * @param fun
     * @return
     */
    public String changeNum(String str, Function<String,String> fun){
        return fun.apply(str);
    }

    /**
     * Predicate<T> 断言型接口，有参数返回值是boolean
     * @param i
     * @param pre
     * @return
     */
    public Boolean judge(Integer i,Predicate<Integer> pre){
        return pre.test(i);
    }


}
