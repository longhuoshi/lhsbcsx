package bcsx.arrays;

import java.util.Arrays;

/**
 * @author l
 * @date 2020/8/19 10:38
 * @description
 *
 * 16.4 多维数组
 *
 */
public class AutoboxingArrays {
    public static void main(String[] args) {
        Integer[][] a = { // Autoboxing:
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
                { 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 },
                { 51, 52, 53, 54, 55, 56, 57, 58, 59, 60 },
                { 71, 72, 73, 74, 75, 76, 77, 78, 79, 80 },
        };
        System.out.println(Arrays.deepToString(a));
    }
}
