package bcsx.arrays;


/**
 * @author l
 * @date 2020/8/19 17:21
 * @description
 */
public class ArrayOfGenericType<T> {
    T[] array;//ok
   public ArrayOfGenericType(int size){
//        array = new T[size]; // Illegal
       array = (T[])new Object[size]; // "unchecked" Warning
   }

    // Illegal:
//   public static <U> U[] makeArray(){
//       return  new U[10];
//   }
}
