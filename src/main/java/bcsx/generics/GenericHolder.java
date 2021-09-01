package main.java.bcsx.generics;

public class GenericHolder<T> {
	private T obj;
	public void set(T t){this.obj = obj;}
	public T get(){return obj;}
	
	public static void main(String[] args) {
		GenericHolder<String> holder = new GenericHolder<String>();
		holder.set("Item");
		String s = holder.get();
	}

}
