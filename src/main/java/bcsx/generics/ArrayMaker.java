package bcsx.generics;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

class Lhs{
	private static int num=0;
	private final int counter = num++;
	public String toString(){
		return "������ "+counter+"��";
	}
}
public class ArrayMaker<T> {
	private Class<T> kind;
	public ArrayMaker(Class<T> kind){this.kind = kind;}
	
	@SuppressWarnings("unchecked")
	T[] create(int size){
		//ע�⣺���� �ڷ����д������飬ʹ��Array.newInstance()���Ƽ���ʽ ��
		return (T[])Array.newInstance(kind, size); 
	}
	
	T[] create2(int size){
		
		//��������
		T[] t = (T[])Array.newInstance(kind, size);
		try {
			//��ֵ
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
