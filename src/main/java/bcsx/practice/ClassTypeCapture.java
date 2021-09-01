package bcsx.practice;

import java.util.HashMap;
import java.util.Map;

class Building{ 
	
	public String toString(){
		return "hi..."+System.currentTimeMillis();
	}
}
class House extends Building{}

public class ClassTypeCapture<T> {
	

	Class<T> kind;
	public ClassTypeCapture(Class<T> kind){
		this.kind = kind;
	}

	
	public boolean f(Object arg){
		
		return kind.isInstance(arg);
	}
	
	//练习部分。
	Map<String,Class<T>> kindMap;
	public void addType(String typename,Class<T> kind){
		if(kindMap == null)
			kindMap = new HashMap<String,Class<T>>();
		kindMap.put(typename, kind);
		
	}
	
	public T createNew(String typeName){
		Class<T> c = kindMap.get(typeName);
		try {
			return c.newInstance();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	

	public static void main(String[] args) {
		ClassTypeCapture<Building> ctc = new ClassTypeCapture<Building>(Building.class);
		System.out.println(ctc.f(new Building()));
		System.out.println(ctc.f(new House()));
		
		ClassTypeCapture<House> ctc2 = new ClassTypeCapture<House>(House.class);
		System.out.println(ctc2.f(new Building()));
		System.out.println(ctc2.f(new House()));
		
		//实现了动态创建类。
		ctc2.addType("aaaa", House.class);
		House newHouse = ctc2.createNew("aaaa");
		System.out.println(newHouse);
		
		
	}

}
