package com.hss.jsCodeExecute;

import javax.script.*;

/**
 * java 实现 javascript 代码执行
 * 实现逻辑编排
 */
public class JsRealize {

    /**
     * 执行js函数，并获取返回值
     * @param expression
     * @return
     * @throws Exception
     */
    public static boolean jsRealizeFunction(String expression) throws Exception {
        // 获取JS执行引擎
        ScriptEngine se = new ScriptEngineManager().getEngineByName("javascript");
        // 获取变量
        Bindings bindings = se.createBindings();
        se.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
        // 拼接JS代码
        String functionCode = "function relationEstimate() { return " + expression + ";}";
        System.out.println(functionCode);
        se.eval(functionCode);
        // 是否可调用
        if (se instanceof Invocable) {
            Invocable in = (Invocable) se;
            return (boolean) in.invokeFunction("relationEstimate");
        }
        return false;
    }

    public static void main(String[] args) throws Exception {

        String expression = "true && false";
        System.out.println(JsRealize.jsRealizeFunction(expression));
    }
}
