package bcsx.arrays;

import bcsx.net.mindview.util.Generated;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @author l
 * @date 2020/9/3 15:47
 * @description
 *
 * 16.7.3 数组元素的比较.
 * Collections.reverseOrder产生一个Comparator 倒序练习
 */
public class Reverse {
    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12],CompType.generator());

        System.out.println("before sorting:");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(a));

    }
}
