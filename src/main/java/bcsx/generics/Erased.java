package bcsx.generics;
/*
 * 擦除丢失了在泛型代码中执行某些操作的能力。
 * 写代码时要注意确切类型信息的操作都无法工作
 * */
public class Erased<T> {
	private final int SIZE  = 100;
	public Erased(Class<T> a){
		Class<T> aaa = a;
		
	}
	public static void f(Object arg){
	
//		if(arg instanceof T){}  //Error  因为其类型信息已经被擦除。
//		T var = new T();        //Error
//		T[] array = new T[SIZE];//Error
//		T[] array = (T)new Object[SIZE];
		
		
	}

}
