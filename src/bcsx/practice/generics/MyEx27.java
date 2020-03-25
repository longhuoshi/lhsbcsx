package bcsx.practice.generics;

import java.util.ArrayList;
import java.util.List;

public class MyEx27 {

	public static void main(String[] args) {
		// compile error: incompatible types:
//		 List<Number> lnum = new ArrayList<Integer>();
		List<? extends Number> nlist = new ArrayList<Integer>();
//		nlist.add(new Integer(0));
		nlist.add(null);
		Number x = nlist.get(0);// can get Number (null)
		System.out.println(nlist);
		
		
		
	}

}
