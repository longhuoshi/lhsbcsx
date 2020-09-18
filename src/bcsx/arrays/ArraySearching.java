package bcsx.arrays;

import bcsx.net.mindview.util.ConvertTo;
import bcsx.net.mindview.util.Generated;
import bcsx.net.mindview.util.Generator;
import bcsx.net.mindview.util.RandomGenerator;

import java.util.Arrays;
import static bcsx.net.mindview.util.Print.*;
/**
 * @author l
 * @date 2020/9/3 17:14
 * @description
 *
 * 16.7.5 在已排序的数组中查找。
 *
 */
public class ArraySearching {
    public static void main(String[] args) {
        Generator<Integer> gen = new RandomGenerator.Integer(1000);
        int[] a = ConvertTo.primitive(Generated.array(new Integer[25],gen));
        print("before sorted:"+Arrays.toString(a));
        Arrays.sort(a);
        print("Sorted array:"+ Arrays.toString(a));
        while(true){
            int r = gen.next();
            int location = Arrays.binarySearch(a,r);
            if(location >=0){
                print("Location of "+r+" is "+location +",a["+location+"] = "+a[location]);
                break; //out of loop
            }
        }
        int location = Arrays.binarySearch(a,206);
        print("location:"+location);

    }
}
