package bcsx.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author l
 * @date 2020/8/19 16:24
 * @description
 *
 * 16.5 数组与泛型
 */
public class ArrayOfGenerics {
    
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[])la;// "Unchecked" warning
        ls[0] = new ArrayList<String>();
        // Compile-time checking produces an error:
        //Incompatible types. Found: 'ArrayList<Integer>', required: 'List<String>'
//        ls[1] = new ArrayList<Integer>();

        // The problem: List<String> is a subtype of Object
        Object[] objects = ls;// so assignment is ok
        // Compiles and runs without complaint:
        objects[1] = new ArrayList<Integer>();

        // However, if your needs are straightforward it is
        // possible to create an array of generics, albeit
        // with an "unchecked" warning:
        List<BerylliumSphere>[] shperes = (List<BerylliumSphere>[])new List[10];
        for (int i = 0; i < shperes.length; i++) {
            shperes[i] = new ArrayList<BerylliumSphere>();
        }

    }
}
