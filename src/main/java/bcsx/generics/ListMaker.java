package main.java.bcsx.generics;

import java.util.ArrayList;
import java.util.List;

public class ListMaker<T> {
	
	List<T> create(){return new ArrayList<T>();}
	
	public static void main(String[] args) {
		ListMaker<String> sMaker = new ListMaker<String>();
		List<String> l = sMaker.create();
//		System.out.println(l.toString());
	}

}
