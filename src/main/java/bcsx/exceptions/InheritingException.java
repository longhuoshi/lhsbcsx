package bcsx.exceptions;

class SimpleException extends Exception{}
/**
 * �����Զ����쳣��
 * */
public class InheritingException {
	public void f() throws SimpleException{
		System.out.println("Throw SimpleException from f()");
		throw new SimpleException();
	}
	
	public static void main(String[] args) {
		InheritingException sed = new InheritingException();
		try {
			sed.f();
		} catch (SimpleException e) {
			e.printStackTrace(System.err);
		}
	}

}
