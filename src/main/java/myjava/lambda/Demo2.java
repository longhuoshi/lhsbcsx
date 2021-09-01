package main.java.myjava.lambda;

/**
 * @author l
 * @date 2019/12/11 15:17
 * @description
 *
 * Lambda表达式有什么作用?
 * 代码简洁
 *
 * 最直观的作用就是使得代码变得异常简洁。
 *
 * 我们可以对比一下Lambda表达式和传统的Java对同一个接口的实现：
 *
 */



public class Demo2 {

    //函数接口
    @FunctionalInterface
    interface MyLambdaInterface{
        void doSomeShit(String s);
    }

    //java8
    MyLambdaInterface aBlockOfCode = (s)->System.out.println(s);

    //java7
    public class MyInterfaceImpl implements MyLambdaInterface{

        @Override
        public void doSomeShit(String s) {
            System.out.println(s);
        }
    }

    MyLambdaInterface anInterfaceImpl = new MyInterfaceImpl();
}
