package main.java.bcsx.practice.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * 15.8.1 创建类型实例。 
 * 练习24:（3）修改练习21，使得工厂对象是由一个Map而不是Class<?>持有的。
 * 引用如下 ：
	 * 15.8擦除的补偿
	 * 练习21：（4）ClassTypeCapture.java，添加一个Map<string,class<?>>,一个
	 * addType(String typename,Class<?> kind)方法和一个createNew(String typename)、
	 * 方法。createNew()将产生与其参数字符串相关联的类的新实例。或者产生一条错误消息。
 * */

interface Factory<T>{
	T create();
}

class Building2{}
class House2 extends Building2{}

class BuildingFactory implements Factory<Building2>{
	@Override
	public Building2 create() {
		return new Building2();
	}
}

class HouseFactory implements Factory<House2>{
	@Override
	public House2 create() {
		return new House2();
	}
}




public class ClassTypeCapture24{
	Class<?> kind;
	public ClassTypeCapture24(Class<?> kind){
		this.kind = kind;
	}
	Map<String,Factory> map;
	public ClassTypeCapture24(Class<?> kind,Map<String,Factory> map){
		this.kind = kind;
		this.map = map;
	}
	
	public boolean f(Object arg){
		return kind.isInstance(arg);
	}
	public void addType(String typename,Factory factory){
		map.put(typename, factory);
	}
	public Object createNew(String typename) throws IllegalAccessException, InstantiationException{
		if(map.containsKey(typename))
			return map.get(typename).create();
			
		System.out.println(typename + " class not available");
		return null;
	}
	
	public static void main(String[] args) {
		ClassTypeCapture24 ctt1 = new ClassTypeCapture24(Building2.class);
		System.out.println(ctt1.f(new Building2()));
		System.out.println(ctt1.f(new House2()));
		
		ClassTypeCapture24 ctt2 = new ClassTypeCapture24(House2.class);
		System.out.println(ctt2.f(new Building2()));
		System.out.println(ctt2.f(new House2()));
		
		ClassTypeCapture24 ct = new ClassTypeCapture24(Building.class,new HashMap<String, Factory>());
		ct.addType("House", new HouseFactory());
		ct.addType("Building", new BuildingFactory());
		System.out.println("ct.map = "+ct.map);

		
		try {
			Building2 b = (Building2) ct.createNew("Building");
			House2 h = (House2) ct.createNew("House");
			System.out.print("b.getClass().getName():");
			System.out.println(b.getClass().getName());
			System.out.print("h.getClass().getName():");
			System.out.println(h.getClass().getName());
			
			System.out.print("House2 h is instance House2:");
			System.out.println(h instanceof House2);
			System.out.print("House2 h is instance Building2:");
			System.out.println(h instanceof Building2);
			System.out.print("Building2 b is instance of House2:");
			System.out.println(b instanceof House2);
			
			ct.createNew("String");//String class not available
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		
		
	}

}
