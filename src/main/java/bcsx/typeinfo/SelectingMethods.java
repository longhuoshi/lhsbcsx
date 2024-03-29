package bcsx.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 14.7 ��̬����
 * */
class MethodSelector implements InvocationHandler{
	private Object proxied;
	public MethodSelector(Object proxied){
		this.proxied = proxied;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().equals("interesting"))
			System.out.println("Proxy detected the interesting method");
		return method.invoke(proxied, args);
	}
	
}

interface SomeMethods{
	void boring1();
	void boring2();
	void interesting(String arg);
	void boring3();
}

class Implementation implements SomeMethods{

	@Override
	public void boring1() {
		System.out.println("boring1");
	}

	@Override
	public void boring2() {
		System.out.println("boring2");
		
	}

	@Override
	public void interesting(String arg) {
		System.out.println("interesting "+arg);
		
	}

	@Override
	public void boring3() {
		System.out.println("boring3");
		
	}
	
}


public class SelectingMethods {

	public static void main(String[] args) {
		SomeMethods someMethods = (SomeMethods) Proxy.newProxyInstance(SomeMethods.class.getClassLoader(), new Class[]{SomeMethods.class}, 
				new MethodSelector(new Implementation()));
		someMethods.boring1();
		someMethods.boring2();
		someMethods.interesting("bonobo");
		someMethods.boring3();
		
	}

}
