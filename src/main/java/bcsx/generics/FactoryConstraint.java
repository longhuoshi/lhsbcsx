package bcsx.generics;

/*
15.8.1 创建类型实例
 * 带编译期检查的泛型
 * 使用显式工厂 实例化
 * */

import bcsx.typeinfo.factory.Factory;

interface FactoryI<T>{
	T create();
}

class Foo2<T>{
	private T x;
	public <F extends FactoryI<T>> Foo2(F factory){
		x = factory.create();
	}
}

class IntegerFactory implements FactoryI<Integer>{

	@Override
	public Integer create() {
		// TODO Auto-generated method stub
		return new Integer(0);
	}
	
}

class Widget{
	public static class Factory implements FactoryI<Widget>{

		@Override
		public Widget create() {
			// TODO Auto-generated method stub
			return new Widget();
		}
		
	}
}

// 自己写的通用实例化工厂
class  CommonF<T> implements FactoryI<T>{
	private Class<T> b;
	public CommonF(Class<T> b){
		this.b = b;
	}
	@Override
	public T create() {
		try {
			return b.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}

class  Mypsflasj{
	@Override
	public String toString() {
		return "Mypsflasj{}";
	}
}

public class FactoryConstraint {

	public static void main(String[] args) {
		new Foo2<Integer>(new IntegerFactory());
		new Foo2<Widget>(new Widget.Factory());


		System.out.println(new CommonF<Mypsflasj>(Mypsflasj.class).create());
		
	}

}
