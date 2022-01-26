package com.hss.jvm.classLoader.dynamicClass;

import javax.tools.*;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * 拼接string内容，生成java片段
 * 编译成class文件，并放入java运行环境中
 */
public class DynamicClass {
    //创建弱引用对象
    private static WeakReference<DynamicClass> mWeakReference = new WeakReference<>(new DynamicClass());

    public static void main(String[] args) {
        eval();
    }

    public static Object eval() {
        //获取弱引用对象
        DynamicClass eval = mWeakReference.get();
        //方法名称
        String method = "handsomeGuy";
        //方法片段代码
        String codes = "public void handsomeGuy(String name){" +
                "System.out.print(\"帅哥---->:\" + name); }";
        eval.run(method,codes);
        return null;
    }

    private Object run(String method,String codes){
        //定义类的className
        String className = "com.test.Eval";
        //拼接Eval中的文本内容
        StringBuilder sb = new StringBuilder();
        sb.append("package com.test;");
        sb.append("\n public class Eval{\n ");
        sb.append(codes);
        sb.append("\n}");
        //核心（由类名和片段生成class文件）
        Class<?> clazz = compile(className, sb.toString());
        try {
            // 获取类示例
            Object obj = clazz.newInstance();
            Class<? extends Object> cls = obj.getClass();
            // 获取方法
            Method m = clazz.getMethod(method,String.class);
            //执行方法并返回
            Object invoke = m.invoke(obj, new Object[] { "hss" });
            return invoke;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /* 装载字符串成为java可执行文件
     * @param className className
     * @param javaCodes javaCodes
     * @return Class
     */
    private  Class<?> compile(String className, String javaCodes) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null, null);
        StrSrcJavaObject srcObject = new StrSrcJavaObject(className, javaCodes);
        Iterable<? extends JavaFileObject> fileObjects = Arrays.asList(srcObject);
        String flag = "-d";
        String outDir = "";
        try {
            File classPath = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI());
            outDir = classPath.getAbsolutePath() + File.separator;
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
        Iterable<String> options = Arrays.asList(flag, outDir);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, options, null, fileObjects);
        boolean result = task.call();
        if (result == true) {
            try {
                return Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static class StrSrcJavaObject extends SimpleJavaFileObject {
        private String content;
        StrSrcJavaObject(String name, String content) {
            super(URI.create("string:///" + name.replace('.', '/') + JavaFileObject.Kind.SOURCE.extension), JavaFileObject.Kind.SOURCE);
            this.content = content;
        }
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return content;
        }
    }
}
