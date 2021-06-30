package bcsx.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 因为擦除在方法体中移除 了类型信息，所以在运行时的问题就是边界；
 * 即对象进入和离开 方法的地点。
 *
 * */

public class FilledListMaker<T> {
	


	List<T> create(T t,int n){
		List<T> list = new ArrayList<T>();
		for(int i=0;i<n;i++){
			list.add(t);
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		FilledListMaker<String> stringMaker = new FilledListMaker<String>();
		List<String> list = stringMaker.create("Hello", 4);
		System.out.println(list);
//		FilledListMaker<Lhs> stringMaker = new FilledListMaker<Lhs>();
//		List<Lhs> list = stringMaker.create(new Lhs(), 4);
//		System.out.println(list);
		
	}

}
