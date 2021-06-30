package bcsx.generics;

/**
 *
 * 15.8.2 泛型数组 1
 *
 * */


public class GenericArray<T> {
	
	private T[] array;
	@SuppressWarnings("unchecked")
	public GenericArray(int size){
		array = (T[])new Object[size];
	}
	
	public void put(int index,T item){
		array[index] = item;
	}
	
	public T get(int index){
		return array[index];
	}
	
	public T[] reg(){
		return array;
	}
	
	public static void main(String[] args) {
		GenericArray<Integer> gai = new GenericArray<Integer>(10);
		gai.put(0, 2323);
		
		// This causes a ClassCastException:
//	    Integer[] ia = gai.reg();
		
	    // This is OK:
		Object[] oa  = gai.reg();
		System.out.println(gai.get(0));
		
	}

}
