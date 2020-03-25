package bcsx.innerclasses;

import java.lang.reflect.Array;
import java.util.ArrayList;

interface PracticeSelector<T>{
	boolean end();
	T current();
	void next();
}
//
//class Lista<T>{
//	private Object[] array;
//	private int i=0;
//	private int size;
//	public Lista(int size){
//		this.size = size;
//		array = new Object[size];
//	}
//	
//	public T get(int index){
//		return (T) array[index];
//	}
//	
//	public void set(T t){
//		if(i<size){
//			array[i] = t;
//		}
//		
//	}
//	
//	 public int length(){
//		 return array.length;
//	 }
//}

public class PracticeSequence<T> {
	private T[] items;
	private int next = 0;
	public PracticeSequence(Class<T> type,int size){
		items = (T[])Array.newInstance(type, size);//类型标记
	}
	public void add(T a){
		if(next <items.length){
			items[next++] = a;
		}
	}
	
	private class PracticeSequenceSelector implements PracticeSelector<T>{
		private  int i= 0;
		@Override
		public boolean end() {
			
			return i == items.length;
		}

		@Override
		public T current() {
			return  items[i];
		}

		@Override
		public void next() {
			if(i<items.length)
				i++;
			
		}
		
	}
	
	public PracticeSelector selector(){
		return new PracticeSequenceSelector();
	}
	
	public static void main(String[] ages){
		PracticeSequence<String> sequence = new PracticeSequence<String>(String.class, 10);
		for(int i=0;i<10;i++){
			sequence.add(Integer.toString(i));
		}
		
		PracticeSelector selector = sequence.selector();
		while(!selector.end()){
			System.out.print(selector.current()+" ");
			selector.next();
		}
		
	}
	
	
}
