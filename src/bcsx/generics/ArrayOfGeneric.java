package bcsx.generics;


public class ArrayOfGeneric {
	static final int SIZE = 100;
	static Generic<Integer>[] gia;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Compiles; produces ClassCastException:
	    //! gia = (Generic<Integer>[])new Object[SIZE];
	    // Runtime type is the raw (erased) type:
		gia = (Generic<Integer>[])new Generic[SIZE];
		System.out.println(gia.getClass().getSimpleName());
		gia[0] = new Generic<Integer>();
		System.out.println(gia[0].getClass().getSimpleName());
//		gia[1] = new Object();// Compile-time error
//		gia[2] = new Generic<Double>();
		
		
		
		
	}

}
