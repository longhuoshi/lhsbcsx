package bcsx.arrays;

import bcsx.net.mindview.util.Generated;
import bcsx.net.mindview.util.Generator;

import java.util.Arrays;
import java.util.Random;

/**
 * @author l
 * @date 2020/9/3 14:39
 * @description
 *
 *16.7.3 数组元素的比较.
 * 比较元素可能实现 java.lang.Comparable接口 通过方法compareTo() 方法，提供比较能力
 * 此方法接受一个Object为参数，如果当前对象小于参数则返回负值，如果相等则返回零，
 * 如果 当前对象大于参数则返回正值。 
 */
public class CompType implements Comparable<CompType> {
    int i;
    int j;
    private static int count = 1;
    public CompType(int n1,int n2){
        i = n1;
        j = n2;
    }
    public String toString(){
        String result = "[i = " + i + ", j = " + j + "]";
        if(count++ % 3 == 0)
            result  += "\n";
        return result;
    }

    @Override
    public int compareTo(CompType rv) {
        return i < rv.i ? -1 : (i == rv.i)  ? 0 : 1 ;
    }

    private static Random r = new Random(47);
    public static Generator<CompType> generator(){
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(r.nextInt(100),r.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12],generator());
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(a));


    }

}
