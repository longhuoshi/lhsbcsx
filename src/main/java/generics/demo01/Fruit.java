package generics.demo01;

import java.lang.reflect.Array;

/**
 * @author l
 * @date 2021/11/25 15:37
 * @description
 * 动态 的创建不同类型的数组？
 *
 */
public class Fruit<T> {
    private T[] array;
    public Fruit(Class<T> clz,int length){
        //通过Array.newInstance创建泛型数组
        array = (T[])Array.newInstance(clz,length);

    }
    //填充数组
    public void put(int index,T item) {
        array[index] = item;
    }

    //获取数组
    public T get(int index) {
        return array[index];
    }
    public T[] getArray() {
        return array;
    }


}
