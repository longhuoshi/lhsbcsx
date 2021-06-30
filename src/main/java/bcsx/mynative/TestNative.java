package bcsx.mynative;

public class TestNative {
	static{

		System.loadLibrary("HelloJNI");
	}
	private native void sayHello();
	
	public static void main(String[] args) {
		
		TestNative tn = new TestNative();
		tn.sayHello();
	}

}
