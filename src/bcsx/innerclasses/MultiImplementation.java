package bcsx.innerclasses;

class D{}
abstract class E{}

//用内部类实现多重继承。
class Z extends D{
	E makeE(){return new E(){};}
}

public class MultiImplementation {
	static void takesD(D d){}
	static void takesE(E e){}

	public static void main(String[] args) {
		Z z = new Z();
		takesD(z);
		takesE(z.makeE());
	}

}
