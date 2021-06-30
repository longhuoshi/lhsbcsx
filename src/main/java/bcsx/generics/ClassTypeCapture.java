package bcsx.generics;

import java.util.HashMap;
import java.util.Map;

class Building{}
class House extends Building{}

public class ClassTypeCapture<T> {
	
	/**
	 * 引入类型标签来对擦除进行补偿。
	 * 
	 * instanceof关键字和isInstance()方法都是用于检查对象的类，都返回一个布尔值。但是当我们想要动态检查对象的类时，
	 * 主要区别就出现了。在这种情况下，isInstance()方法将起作用，而无法通过instanceof运算符来实现这一点。
	 * 定义

	a instanceof B
	a是B的实例，B是类或者接口、父类或父接口
	B.class.isInstance(a)
	
	这个叫动态等价，效果和上面等价，一般用于检查泛型，如jdk中CheckedMap里面用到这个检查Map里面的key、value类型是否和约定的一样。


	 * */
	Class<T> kind;
	public ClassTypeCapture(Class<T> kind){
		this.kind = kind;
	}

//	Map<String,Class<T>> kindMap;
//	public void addType(String typename,Class<T> kind){
//		if(kindMap == null)
//			kindMap = new HashMap<String,Class<T>>();
//		kindMap.put(typename, kind);
//		
//	}
	
	
	
	public boolean f(Object arg){
		
		return kind.isInstance(arg);
	}

	public static void main(String[] args) {
		ClassTypeCapture<Building> ctc = new ClassTypeCapture<Building>(Building.class);
		System.out.println(ctc.f(new Building()));  // Building 是 Building   返回：true
		System.out.println(ctc.f(new House())); // House 是 Building  返回：true
		
		ClassTypeCapture<House> ctc2 = new ClassTypeCapture<House>(House.class);
		System.out.println(ctc2.f(new Building())); // Building 不是 House  返回：false
		System.out.println(ctc2.f(new House())); // House 是 House  返回：true
		
		System.out.println("=========================");
		//Building父类，House是子类
		//house可不可以转换成Building
		System.out.println(new House() instanceof Building);  //House 是 Building  等同于Building.class.isInstance(new House());
		System.out.println(new Building() instanceof House);  //Building 不是 House  返回：false
		
		//Building类型有没有House.
		System.out.println(Building.class.isInstance(new House()));

		
		
		
	}

}
