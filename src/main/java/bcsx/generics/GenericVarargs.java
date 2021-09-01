package bcsx.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {
	
	/**
	 * 与标准库中java.util.Arrays.asList(a)方法相同的功能 。
	 * */
	public static <T> List<T> makeList(T... args){
		List<T> result = new ArrayList<T>();
		for(T item : args)
			result.add(item);
		return result;
	}
	
	public static void main(String[] args) {
		List<String> ls = makeList("A");
		System.out.println(ls);
		ls = makeList("ABCDEFFHI".split(""));
		System.out.println(ls);
		
	}

}
