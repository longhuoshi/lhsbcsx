package bcsx.arrays;

import java.util.Arrays;
import java.util.Random;
/**
 *16.4 多维数组
 * 数组中构成矩阵的每个向量都可以具有任意的长度（这被称为粗糙数组 ）
 * */
public class RaggedArray {

    public static void main(String[] args) {
        Random random = new Random(47);
        int[][][] a = new int[random.nextInt(7)][][];
        for(int i=0;i<a.length;i++){
            a[i] = new int[random.nextInt(5)][];
            for(int j=0;j<a[i].length;j++){
                a[i][j] = new int[random.nextInt(5)];
                //self add
                for(int k=0;k<a[i][j].length;k++){
                    a[i][j][k] = random.nextInt(44);
                }
                
            }
        }
        
        System.out.println(Arrays.deepToString(a));
        
        

    }

}
