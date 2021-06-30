package bcsx.arrays;

import java.util.Arrays;

/**
 *16.2 数组是第一级对象
 *[bə'rɪliəm]  Beryllium
 * */

public class ArrayOptions {

    public static void main(String[] args) {
        BerylliumSphere[] a;
        BerylliumSphere[] b = new BerylliumSphere[5];
        System.out.println("b: "+Arrays.toString(b));

        BerylliumSphere[] c = new BerylliumSphere[4];
        for(int i=0;i<c.length;i++){
            if(c[i]==null){
                c[i] = new BerylliumSphere();
            }
        }
        //聚集初始化(变量= {})操作必须在 变量定义的位置使用。
        BerylliumSphere[] d ={new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere() };
        //动态的聚集初始化(变量=new xx[]{}) 可以在任意位置创建和初始化数组对象。
        //只要是聚集初始化，就不能填写数组长度 
        a = new BerylliumSphere[]{new BerylliumSphere(),new BerylliumSphere()};


        System.out.println("a.length = " + a.length);
        System.out.println("b.length = " + b.length);
        System.out.println("c.length = " + c.length);
        System.out.println("d.length = " + d.length);
        a = d;
        System.out.println("a.length = " + a.length);

        System.out.println("=============================== ");
        //arrays of primitives
        // primitive ['prɪmətɪv]
        int[] e;  // null reference
        int[] f = new int[5];
        System.out.println("f: " + Arrays.toString(f));
        int[] g = new int[4];
        for(int i=0;i<g.length;i++){
            g[i] = i*i;
        }
        int[] h = { 11, 47, 93 };
        //Compile error: variable e not initialized:
//        System.out.println("e.length = " + e.length);
        System.out.println("f.length = " + f.length);
        System.out.println("g.length = " + g.length);
        System.out.println("h.length = " + h.length);
        e = h;
        System.out.println("e.length = " + e.length);
        e = new int[]{1,2};
        System.out.println("e.length = " + e.length);
        System.out.println("=============================== ");
        char[] i = new char[5];
        System.out.println("i: "+Arrays.toString(i));




        
    }

}
