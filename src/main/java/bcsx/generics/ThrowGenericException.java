package bcsx.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author l
 * @date 2020/7/13 17:05
 * @description
 *
 * 15.14 导常
 * previous {@link CheckedList}
 * next {@link Mixins }
 *
 *定义泛型参数化异常
 */
interface Processor<T,E extends Exception>{
    void process(List<T> resultCollector) throws E;  //定义一个给list赋值的抽象方法,方法有个收集参数
}

/**
 *
 * 定义一个存放Processor的list。并且添加一个processAll方法，返回一个处理好的list(其实就是往list里赋值)；
 *  Processor里有个process方法传入一个list，并给这个list赋值。
 * */
class ProcessRunner<T , E extends Exception> extends ArrayList<Processor<T,E>>{
    List<T> processAll() throws E {
        //收集参数
        List<T> resultCollector = new ArrayList<T>();
        for (Processor<T,E> processor : this){  //对象本身是arraylist,然后里面存的是Processor接口类型的对象。
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Failure1 extends Exception{}

class Processor1 implements Processor<String,Failure1>{
    static int count = 3;

    /**
     * process的处理结果存在resultcollector
     * */
    @Override
    public void process(List<String> resultCollector) throws Failure1 {
        if(count-- > 1)
            resultCollector.add("Hep!");
        else{
            resultCollector.add("Ho!");
        }

        if(count < 0)
            throw new Failure1();
    }
}

class Failure2 extends Exception{}
class Processor2 implements Processor<Integer,Failure2>{
    static int count =2 ;
    @Override
    public void process(List<Integer> resultCollector) throws Failure2 {
        if(count-- == 0 )
            resultCollector.add(47);
        else
            resultCollector.add(11);
        if (count<0){
            throw new Failure2();
        }
    }
}


public class ThrowGenericException {
    public static void main(String[] args) {
        ProcessRunner<String,Failure1> runner = new ProcessRunner<String,Failure1>();
        for (int i=0; i<3; i++){
            runner.add(new Processor1());
        }
        try {
            System.out.println(runner.processAll());
        } catch (Failure1 e) {
            System.out.println(e);
        }

        ProcessRunner<Integer,Failure2> runner2 = new ProcessRunner<Integer,Failure2>();
        for (int i = 0; i < 2; i++) {
            runner2.add(new Processor2());
        }
        try {
            System.out.println(runner2.processAll());
        } catch (Failure2 failure2) {
            failure2.printStackTrace();
        }


    }




}
