package main.java.bcsx.generics;

import java.lang.reflect.Array;
import java.util.Random;
/**
 * 创建T类型的数组 ，传类型标记Class<T> 是正确的作法
 * */
public class GenericArrayWithTypeToken<T> {
	private T[] array;
	public GenericArrayWithTypeToken(Class<T> type,int size){
		array = (T[])Array.newInstance(type, size);
	}
	public void put(T item,int index){
		array[index] = item;
	}
	
	public T get(int index){
		return array[index];
	}
	
	public T[] rep(){
		return array;
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		GenericArrayWithTypeToken<Integer> gawtt = new GenericArrayWithTypeToken<Integer>(Integer.class, 10);
		for(int k=0;k<10;k++){
			gawtt.put(random.nextInt(20000), k);
		}
		Integer[] arr = gawtt.rep();
		System.out.println(arr);
		for(int k=0;k<arr.length;k++){
			System.out.println(arr[k]);
		}

	}

}
