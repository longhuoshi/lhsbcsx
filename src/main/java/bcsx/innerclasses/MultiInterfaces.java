package bcsx.innerclasses;
/**
 * 情形：必须 在一个类中以某种方式 实现两个接口。
 * 用内部类去实现 。
 * */
interface A{}
interface B{}

class X implements A,B{}
class Y implements A{
	B makeB(){
		// Anonymous inner class:
		return new B(){};
	}
}

public class MultiInterfaces {
	static void takesA(A a){}
	static void takesB(B b){}

	public static void main(String[] args) {
		X x = new X();
		Y y= new Y();
		takesA(x);
		takesA(y);
		takesB(x);
		takesB(y.makeB());
	}

}
