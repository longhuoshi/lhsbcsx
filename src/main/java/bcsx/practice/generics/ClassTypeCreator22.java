package bcsx.practice.generics;

import java.lang.reflect.InvocationTargetException;
import static bcsx.net.mindview.util.Print.*;

/**
 * 15.8.1 创建类型实例。 
 * 练习22:(6)使用类型标签与反射来创建一个方法，它将使用newInstance()参数版本来、
 * 创建某个类的对象，这个类拥有一个具有参数的构造器
 * 
 * */
class Building{}
class House extends Building{
	private String location;
	private Integer area;
	public House(){location = null;}
	public House(String location){
		this.location = location;
	}
	
	public House(String location,Integer area){
		this.location = location;
		this.area = area;
	}
	
	public String toString(){
		return "House"+((location == null) ? "" : (" in "+location) ) + 
				((area!=null) ? (","+area+" sqft") : "");
	}
}

public class ClassTypeCreator22 {//ClassTypeCreator22<T>
//	Class<?> kind;
//	public ClassTypeCreator22(Class<?> kind){
//		this.kind = kind;
//	}
	public Object createNew(String typeName) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return Class.forName(typeName).newInstance();
	}
	
	public Object createNew(String typeName,Object... args) 
			throws InstantiationException, IllegalAccessException, 
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException{
		switch (args.length) {
		case 1:
			return Class.forName(typeName).getConstructor(args[0].getClass()).newInstance(args[0]);
		case 2:
			return Class.forName(typeName).getConstructor(args[0].getClass(),args[1].getClass())
					.newInstance(args[0],args[1]);
		}
		
		return null;
	}
	
	public static void main(String[] args) {
//		ClassTypeCreator22<Building> ctb = new ClassTypeCreator22<Building>(Building.class);
//		ClassTypeCreator22<House> cth = new ClassTypeCreator22<House>(House.class);
		try {
//			Building b = (Building) ctb.createNew("Building");
//			House h = (House) cth.createNew("bcsx.practice.main.java.generics.House");
//			House h2 = (House) cth.createNew("bcsx.practice.main.java.generics.House","shanghai");
			
			
			
			ClassTypeCreator22 ct = new ClassTypeCreator22();
			Building b = (Building) ct.createNew("bcsx.practice.main.java.generics.Building");
			House h3 = (House) ct.createNew("bcsx.practice.main.java.generics.House","shanghai",1000);
			print(b);
			print(h3);
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
