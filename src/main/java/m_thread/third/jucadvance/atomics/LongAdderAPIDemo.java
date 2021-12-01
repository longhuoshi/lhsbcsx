package m_thread.third.jucadvance.atomics;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author l
 * @date 2021/11/29 16:05
 * @description
 */
public class LongAdderAPIDemo {
    public static void main(String[] args) {
        //有个弊端：只能做加法
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        longAdder.increment();
        longAdder.increment();
        System.out.println(longAdder.longValue());
        System.out.println("---------------LongAccumulator---------------");
//        LongAccumulator longAccumulator = new LongAccumulator((x,y)->{return  x+y;},0) ;
        LongAccumulator longAccumulator = new LongAccumulator((x,y)->x-y,10) ;
        longAccumulator.accumulate(1);
        longAccumulator.accumulate(2);
        longAccumulator.accumulate(3);
        System.out.println(longAccumulator.longValue());

    }
}
