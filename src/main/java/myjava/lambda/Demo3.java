package myjava.lambda;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * @author l
 * @date 2019/12/11 16:58
 * @description
 *
 *Lambda可以直接赋值给一个变量
 *
 * 由于Lambda可以直接赋值给一个变量，我们就可以直接把Lambda作为参数传给函数,
 * 而传统的Java必须有明确的接口实现的定义，初始化才行：
 *
 *有些情况下，这个接口实现只需要用到一次。传统的Java 7必须要求你定义一个“污染环境”的接口实现MyInterfaceImpl，
 * 而相较之下Java 8的Lambda, 就显得干净很多。
 *
 *
 *
 */


public class Demo3 {

    //函数接口
    @FunctionalInterface
    interface MyLambdaInterface{
        void doSomeShit(String s);
    }

    public static void enact(MyLambdaInterface myLambda,String x){
        myLambda.doSomeShit(x);
    }

    //java7
    static class MyInterfaceImpl implements MyLambdaInterface{

        @Override
        public void doSomeShit(String s) {
            System.out.println(s);
        }
    }


    public static void main(String[] args) {
        //java8
        enact(s -> System.out.println(s),"my is lambda");

        //java7
        MyLambdaInterface anInterfaceImpl = new MyInterfaceImpl();
        enact(anInterfaceImpl,"my is java7");


    }


}
