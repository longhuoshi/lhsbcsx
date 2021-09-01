package main.java.bcsx.practice;

import java.util.ArrayList;
import java.util.List;

interface Selector{
	boolean end();
	Object current();
	void next();
}

public class Sequence<T> {
	private List<T> items = new ArrayList<T>();
	private int next = 0;
	public Sequence(List<T> list){
		if(list !=null)
			items = list;
	}
	private void add(T x){
		items.add(x);
	}
	private class SequenceSelector implements Selector{
		private int i = 0;
		@Override
		public boolean end() {
//			if(next == items.size())
//				return true;
//			else
//				return false;
			return i== items.size();
		}

		@Override
		public Object current() {
			return items.get(i);
		}

		@Override
		public void next() {
			if(i<items.size())
				i++;
			
		}
		
	}
	public Selector selector(){
		return new SequenceSelector(); 
				
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Sequence<Integer> sequence = new Sequence<Integer>(list);
		
		for(int i=0;i<10;i++){
			sequence.add(i);
		}
		Selector selector = sequence.selector();
		while(!selector.end()){
			System.out.print(selector.current()+" ");
			selector.next();
		}
		System.out.println();
	}

}
