package main.java.bcsx.typeinfo;

import main.java.bcsx.typeinfo.interfacea.A;

/**
 * Anonymous inner calsses can't hide from reflection.
 * */

class AnonymousA{
	public static A makeA(){
		return new A(){
			@Override
			public void f() {
				System.out.println("public C.f()");
			}
			public void g() {
				System.out.println("public C.g()");
			}
			void u(){ System.out.println("package C.u()"); }
			
			protected void v(){ System.out.println("protected C.v()"); }
			private void w(){ System.out.println("protected C.w()"); } 
			
		};
		
	}
}

public class AnonymousImplementation {
	public static void main(String[] args) throws Exception {
		A a = AnonymousA.makeA();
		a.f();
		HiddenImplementation.callHiddenMethod(a, "g");
		HiddenImplementation.callHiddenMethod(a, "u");
		HiddenImplementation.callHiddenMethod(a, "v");
		HiddenImplementation.callHiddenMethod(a, "w");
	}

}
