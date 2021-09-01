package main.java.bcsx.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomList<T> {
	
	private List<T> list = new ArrayList<T>();
	private Random random = new Random(47);
	public void  add(T item){
		list.add(item);
	}
	public T select(){
		return list.get(random.nextInt(list.size()));
	}
	public static void main(String[] args) {
		RandomList<String> r = new RandomList<String>();
		for(String s : "The quick brown fox jumped over the lazy brown dog".split(" "))
			r.add(s);
		
		for(int i=0;i<11;i++){
			System.out.print(r.select()+" ");
		}
		
		
	}

}
