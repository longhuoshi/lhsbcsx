package bcsx.typeinfo;


/**
 * 14.5 instanceof��Class�ĵȼ��ԡ�
 * */

class Base{}
class Derived extends Base{}
public class FamilyVsExactType {
	static void test(Object x){
		System.out.println("Testing x of type "+x.getClass());
		System.out.println("x instanceof Base "+(x instanceof Base));
		//x��Derived���𡣻���˵x��Derived����������?
		System.out.println("x instanceof Derived "+(x instanceof Derived));
		System.out.println("Base.class.isInstance(x) "+ Base.class.isInstance(x));
		System.out.println("Derived.class.isInstance(x) "+ Derived.class.isInstance(x));
		System.out.println("x.getClass() == Base.class "+ (x.getClass() == Base.class));
		System.out.println("x.getClass() == Derived.class "+ (x.getClass() == Derived.class));
		System.out.println("x.getClass().equals(Base.class) "+ (x.getClass().equals(Base.class)));
		System.out.println("x.getClass().equals(Derived.class) "+ (x.getClass().equals(Derived.class)));
	}
	
	public static void main(String[] args) {
		test(new Base());
		System.out.println("----------------------------------------------");
		test(new Derived());
	}

}
