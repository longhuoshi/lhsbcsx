package bcsx.arrays;

import bcsx.net.mindview.util.ConvertTo;
import bcsx.net.mindview.util.CountingGenerator;
import bcsx.net.mindview.util.Generated;

import java.util.Arrays;

/**
 * @author l
 * @date 2020/8/21 11:06
 * @description
 *
 * 16.6.3 从Generator中创建数组
 */
public class PrimitiveConversionDemonstration {
    public static void main(String[] args) {
        Integer[] a = Generated.array(Integer.class,new CountingGenerator.Integer(),15);
        int[] b = ConvertTo.primitive(a);
        System.out.println(Arrays.toString(b));
        boolean[] c = ConvertTo.primitive(Generated.array(Boolean.class,new CountingGenerator.Boolean(),7));
        System.out.println(Arrays.toString(c));

    }
}
