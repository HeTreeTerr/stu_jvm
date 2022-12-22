package com.hss.codeExecute.groovy;

import javax.script.*;
import java.util.HashMap;
import java.util.Map;

/**
 * java 实现 groovy 代码执行
 * 实现逻辑编排
 */
public class GroovyRealize {

    /** 定义groovy脚本中执行方法的名称 */
    private static final String scriptName = "execute";

    /** 定义groovy脚本内容 */
    private static final String scriptContent = "def " + scriptName +"(){" +
            "    println(\"a is: ${a}, b is:${b}, a || b\");" +
            "    return a || b;" +
            "}";

    /** 查找并创建指定脚本引擎 */
    private ScriptEngine engine = new ScriptEngineManager().getEngineByName("groovy");

    /**
     * 执行groovy方法，并获取结果
     * @param param
     */
    public void runByFunction(Map<String,Object> param){
        // 初始化Bindings
        Bindings bindings = engine.createBindings();
        // 绑定参数
        bindings.putAll(param);
        try {
            // 执行脚本
            engine.eval(scriptContent, bindings);
            // 获取执行结果
            Invocable invocable = (Invocable) engine;
            Boolean flag = (Boolean) invocable.invokeFunction(scriptName);
            System.out.println("result is: " + flag);
        } catch (ScriptException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        GroovyRealize realize = new GroovyRealize();
        //拼装参数
        Map map = new HashMap<>();
        map.put("a",false);
        map.put("b",false);
        //执行脚本
        realize.runByFunction(map);
    }
}
