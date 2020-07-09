package bcsx.generics;

import bcsx.net.mindview.util.Generator;
import bcsx.net.mindview.util.RandomGenerator;

/**
 * @author l
 * @date 2020/6/17 15:56
 * @description
 *15.11 问题
 * 15.11.1
 */


class FArray{
    public  static <T> T[] fill(T[] arr, Generator<T> gen){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = gen.next();
        }
        return arr;
    }
}

public class PrimitiveGenericTest {
    public static void main(String[] args) {
        String[] strings = FArray.fill(new String[7],new RandomGenerator.String(10));
        for (String s : strings)
            System.out.println(s);

        Integer[] integers = FArray.fill(new Integer[7],new RandomGenerator.Integer());
        for (Integer i : integers)
            System.out.println(i);

        //Autoboxing won't save you here. This won't compile :
//        int[] b = FArray.fill(new int[7],new RandomGenerator.Integer());
        /**
         * 由于RandomGenerator.Integer实现了Generator<Integer>,所以我的希望是自动包装机制
         * 可以自动地将next()的值从integer转换为int。但是，自动包装机制不能应用于数组，因此
         * 这无法工作。
         * */


    }
}
