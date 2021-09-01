package main.java.bcsx.typeinfo;

import main.java.bcsx.typeinfo.interfacea.A;

class B implements A{

	@Override
	public void f() {
	}
	
	public void g(){
	}
	
}

public class InterfaceViolation {

	public static void main(String[] args) {
		A a = new B();
		a.f();
//		a.g();  Compile error
		System.out.println(a.getClass().getSimpleName());
		if(a instanceof B){
			B b = (B)a;
			b.g();
		}
	}

}
