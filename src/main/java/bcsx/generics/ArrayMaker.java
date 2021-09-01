package main.java.bcsx.generics;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

class Lhs{
	private static int num=0;
	private final int counter = num++;
	public String toString(){
		return "机器人 "+counter+"号";
	}
}
public class ArrayMaker<T> {
	private Class<T> kind;
	public ArrayMaker(Class<T> kind){this.kind = kind;}
	
	@SuppressWarnings("unchecked")
	T[] create(int size){
		//注意：对于 在泛型中创建数组，使用Array.newInstance()是推荐方式 。
		return (T[])Array.newInstance(kind, size); 
	}
	
	T[] create2(int size){
		
		//创建数组
		T[] t = (T[])Array.newInstance(kind, size);
		try {
			//赋值
			for(int i=0; i< t.length ; i++){

				T a =kind.newInstance();
				t[i] = a;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t; 
	}

	public static void main(String[] args) {
//		ArrayMaker<String> stringMaker = new ArrayMaker<String>(String.class);
//		String[] stringArray = stringMaker.create(9);
//		System.out.println(Arrays.toString(stringArray));
		ArrayMaker<Lhs> stringMaker = new ArrayMaker<Lhs>(Lhs.class);
		Lhs[] stringArray = stringMaker.create2(9);
		System.out.println(Arrays.asList(stringArray));
	}

}
