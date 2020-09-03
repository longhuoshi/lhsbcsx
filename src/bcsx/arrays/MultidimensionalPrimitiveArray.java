package bcsx.arrays;

import java.util.Arrays;

/**
 * 16.4 多维数组
 *
 * */

public class MultidimensionalPrimitiveArray {

    public static void main(String[] args) {
        int[][] a = {
            {1,2,3},
            {4,5,6}
        };


        System.out.println(Arrays.deepToString(a));
        
        // 3-D array with fixed length:
        int[][][] b = new int[2][2][4];
        b[0] = a;
        b[1][1] = new int[]{7,8,9,22,33,44};
        b[1][1][0] = 10;
        System.out.println(Arrays.deepToString(b));
        System.out.println(b[0][0][0]);
        System.out.println(b[1][0][0]);
        System.out.println(b[1][0][1]);
        System.out.println(b[1][1][1]);
    }

}
