package bcsx.arrays;

import bcsx.net.mindview.util.CountingGenerator;
import bcsx.net.mindview.util.Generated;
import bcsx.net.mindview.util.RandomGenerator;

import java.util.Arrays;

/**
 * @author l
 * @date 2020/8/21 10:24
 * @description
 *
 *16.6.3 从Generator中创建数组
 */
public class TestGenerated {
    public static void main(String[] args) {
        Integer[] a = {9, 8, 7, 6};
        System.out.println(Arrays.toString(a));
        Generated.array(a, new CountingGenerator.Integer());
        System.out.println(Arrays.toString(a));
        Integer[] b = Generated.array(Integer.class,new CountingGenerator.Integer(),8);
        System.out.println(Arrays.toString(b));



    }
}
