package main.java.bcsx.typeinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.java.bcsx.typeinfo.factory.Factory;

/**
 * 14.4 ע�Ṥ��
 * �������ʾ���У�����Part����һ ������������б�����Ӧ�����createRandom()�������������ͣ�
 * ���ǵĹ���������ӵ���partFactories List�У��Ӷ���ע�ᵽ�˻����С�
 * 
 * 
 * */

class Part{
	public String toString(){
		return getClass().getSimpleName();
	}
	
	static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
	static{
		// Collections.addAll() gives an "unchecked generic
	    // array creation ... for varargs parameter" warning.
//		partFactories.add(new MyTest().create());
		partFactories.add(new FuelFilter.Factory());
		partFactories.add(new AirFilter.Factory());
		partFactories.add(new CabinAirFilter.Factory());
		partFactories.add(new OilFilter.Factory());
		partFactories.add(new FanBelt.Factory());
		partFactories.add(new GeneratorBelt.Factory());
		partFactories.add(new PowerSteeringBelt.Factory());
		
		
	}
	
	private static Random rand = new Random(47);
	public static Part createRandom(){
		int n = rand.nextInt(partFactories.size());
		return partFactories.get(n).create();
		
	}
}

class Filter extends Part{}

//class MyTest extends Part implements Factory<MyTest>{
//	@Override
//	public MyTest create() {
//		return new MyTest();
//	}
//}

class FuelFilter extends Filter{
	public static class Factory implements main.java.bcsx.typeinfo.factory.Factory<FuelFilter>{
		@Override
		public FuelFilter create() { return new FuelFilter(); }
	}
}
class AirFilter extends Filter{
	public static class Factory implements main.java.bcsx.typeinfo.factory.Factory<AirFilter>{
		@Override
		public AirFilter create() { return new AirFilter(); }
	}
}
class CabinAirFilter extends Filter{
	public static class Factory implements main.java.bcsx.typeinfo.factory.Factory<CabinAirFilter>{
		@Override
		public CabinAirFilter create() { return new CabinAirFilter(); }
	}
}

class OilFilter extends Filter{
	public static class Factory implements main.java.bcsx.typeinfo.factory.Factory<OilFilter>{
		@Override
		public OilFilter create() { return new OilFilter(); }
	}
}

class Belt extends Part{}
class FanBelt extends Belt{
	public static class Factory implements main.java.bcsx.typeinfo.factory.Factory<FanBelt>{
		@Override
		public FanBelt create() { return new FanBelt(); }
	}
}
class GeneratorBelt extends Belt{
	public static class Factory implements main.java.bcsx.typeinfo.factory.Factory<GeneratorBelt>{
		public GeneratorBelt create(){ return new GeneratorBelt();}
	}
}

class PowerSteeringBelt extends Belt{
	public static class Factory implements main.java.bcsx.typeinfo.factory.Factory<PowerSteeringBelt>{
		public PowerSteeringBelt create(){ return new PowerSteeringBelt();}
	}
}


public class RegisteredFactories {
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			System.out.println(Part.createRandom());
		}
	}
}
