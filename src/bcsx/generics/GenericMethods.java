package bcsx.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {
	/**
	 * 注意，当使用泛型类时，必须在创建对象的时候指定类型参数的值，而使用泛型方法的时候，通常不必指明参数类型，
	 * 因为编译器会为我们找出具体 的类型。这称为 类型参数推断 (type argument inference)。因此我们可以
	 * 像调用普通方法一样调用f()，而且就好像是f()无限次地重载过。	
	 * */
	public <T> void f(T t){
		System.out.println(t.getClass().getName());
	}
	public <T,A> void f2(T t,A a,Double b){
		System.out.println(t.getClass().getName()+" "+a.getClass().getName()+" "+b.getClass().getName());
	}
	
	public static void main(String[] args){
		GenericMethods gm = new GenericMethods();
		gm.f(" ");
		gm.f(1);
		gm.f(1.0);
		gm.f(1.0F);
		gm.f('c');
		gm.f(gm);
		
		gm.f2("bb", 1, 1.0);
	}
}
