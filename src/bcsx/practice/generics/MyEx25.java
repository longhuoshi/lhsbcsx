package bcsx.practice.generics;

/**
 * 创建两个接口和一个实现了这两个接口的类。创建两个泛型方法，其中一个参数边界限定为第一个接口，
 * 而另一个的参数边界被限定为第二个接口。创建实现了这两个接口的类的实例，并展示它可以用于
 * 这两个泛型方法。 
 * 
 * */

interface TwoLeg{
	void fly();
}
interface FourLeg{void running();}

class Animal implements TwoLeg,FourLeg{
	
	
	@Override
	public void fly() {
		System.out.println("丫的，别欺负我只有两只脚，我可以飞呀！");
		
	}

	@Override
	public void running() {
		System.out.println("我四只脚，我比谁都跑得快！");
		
	}
}



public class MyEx25 {
	public <T extends TwoLeg> void  chicken(T t){
		t.fly();
	}

	public <T extends FourLeg> void  cow(T t){
		t.running();
	}
	
	public static void main(String[] args) {
		MyEx25 c = new MyEx25();
		c.cow(new Animal());
		c.chicken(new Animal());
	}

}
