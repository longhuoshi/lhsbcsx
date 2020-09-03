package bcsx.arrays;

import java.util.Arrays;

/**
 * @author l
 * @date 2020/8/18 11:47
 * @description
 *
 * 16.4 多维数组
 * 可以用类的方式 处理非基本类型的对象数组
 */
public class MultidimensionalObjectArrays {
    public static void main(String[] args) {
        BerylliumSphere[][] spheres = {
          {new BerylliumSphere(),new BerylliumSphere()},
          {new BerylliumSphere(),new BerylliumSphere(),
           new BerylliumSphere(),new BerylliumSphere()},
          {new BerylliumSphere(),new BerylliumSphere(),
          new BerylliumSphere(),new BerylliumSphere(),
          new BerylliumSphere(),new BerylliumSphere(),
          new BerylliumSphere(),new BerylliumSphere()},
        };

        System.out.println(Arrays.deepToString(spheres));

    }
}
