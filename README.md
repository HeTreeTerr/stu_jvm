# stu_jvm
java虚拟机，从入门到入土

## 1.计数器（寄存器） 
作用，是记住下一条jvm指令的执行地址
特点:
* 是线程私有的
* 不会存在内存溢出

## 2.栈（先进后出）
* 每个线程运行时所需要的内存，称为虚拟机栈
* 每个栈由多个栈帧（Frame）组成，对应着每次方法调用时所占用的内存[如请求参数、方法的局部变量和返回地址]
* 每个线程只能有一个活动栈帧，对应着当前正在执行的那个方法

## 3.本地方法栈
* 给java中，非java代码编写的基础类库，提供运行空间。

