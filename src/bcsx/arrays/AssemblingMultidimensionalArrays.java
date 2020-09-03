package bcsx.arrays;

import java.util.Arrays;

/**
 * @author l
 * @date 2020/8/19 10:40
 * @description
 *
 * 16.4 多维数组
 */
public class AssemblingMultidimensionalArrays {
    public static void main(String[] args) {
        Integer[][] a;
        a = new Integer[3][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Integer[3];
            for(int j = 0 ;j < a[i].length; j++){
                a[i][j] = i*j ; //Autoboxing
            }
        }
        System.out.println(Arrays.deepToString(a));
    }
}
