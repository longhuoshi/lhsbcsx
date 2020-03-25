package myjava.lambda;

/**
 * @author l
 * @date 2019/12/11 11:48
 * @description
 *
 *什么是Lambda?
 * 我们知道，对于一个Java变量，我们可以赋给其一个“值”。
 *
 * 如果你想把“一块代码”赋给一个Java变量，应该怎么做呢？
 */
public class Demo {

    /**
     * 假如我要把这个方法赋值给一个变量要怎么做呢。
     * 这样吗
     * aBlockOfCode =  public void doSomeShit(String s){
     *         System.out.println(s);
     *     }
     *当然，这个并不是一个很简洁的写法。所以，为了使这个赋值操作更加elegant, 我们可以移除一些没用的声明。
     *
     * aBlockOfCode = (s)->System.out.println(s);
     * 样，我们就成功的非常优雅的把“一块代码”赋给了一个变量。而“这块代码”，或者说“这个被赋给一个变量的函数”，就是一个Lambda表达式。
     * 但是这里仍然有一个问题，就是变量aBlockOfCode的类型应该是什么？
     *
     *
     * */
    public void doSomeShit(String s){
        System.out.println(s);
    }

    /**
     * * 在Java 8里面，所有的Lambda的类型都是一个接口，而Lambda表达式本身，也就是”那段代码“，需要是这个接口的实现。
     * 这是我认为理解Lambda的一个关键所在，简而言之就是，Lambda表达式本身就是一个接口的实现。
     * 直接这样说可能还是有点让人困扰，我们继续看看例子。我们给上面的aBlockOfCode加上一个类型：
     *
     * 这种只有一个接口函数需要被实现的接口类型，我们叫它”函数式接口“。为了避免后来的人在这个接口中
     * 增加接口函数导致其有多个接口函数需要被实现，变成"非函数接口”，我们可以在这个上面加上一个声明@FunctionalInterface,
     * 这样别人就无法在里面添加新的接口函数了：
     *
     * */

    //函数接口
    @FunctionalInterface
    interface MyLambdaInterface{
        void doSomeShit(String s);
    }

    /**
     * 这样，我们就得到了一个完整的Lambda表达式声明
     * */
    MyLambdaInterface aBlockOfCode = (s)->System.out.println(s);



    public static void main(String[] args) {
        int aValue = 129;
        Demo demo = new Demo();
        demo.aBlockOfCode.doSomeShit("同志这里不能撒尿!");
    }

}
