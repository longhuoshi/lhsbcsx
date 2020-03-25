package bcsx.arrays;

import java.util.Arrays;

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
    }

}
