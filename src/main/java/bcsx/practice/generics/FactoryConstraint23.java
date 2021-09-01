package main.java.bcsx.practice.generics;
/**
 * 15.8.1 创建类型实例。 
 * 练习23:（1）修改FactoryConstraint.java,使用create()可以接受一个参数
 * */

interface FactoryI<T>{
	T create(Integer i);
}

class Foo2<T>{
	private T x;
	public void get(){System.out.println(x);}
	public <E extends FactoryI<T>> Foo2(E e,int num){
		x = e.create(num);
	}
}

class IntegerFactory implements FactoryI<Integer>{
	@Override
	public Integer create(Integer i) {
		return new Integer(i);
	}
}

class Widget{
	
	int i;
	public static class Flhs implements FactoryI<Widget>{

		@Override
		public Widget create(Integer i) {
			Widget w = new Widget();
			w.i = i;
			return w;
		}
	}
	public String toString(){
		return "Widget "+i;
	}
}

public class FactoryConstraint23 {
	public static void main(String[] args) {
		Foo2 f1 = new Foo2<Integer>(new IntegerFactory(), 4);
		Foo2 f2 = new Foo2<Widget>(new Widget.Flhs(), 78);
		f1.get();
		f2.get();
	}

}
