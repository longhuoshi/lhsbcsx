package bcsx.innerclasses;

/**
 * 局部内部类。
 * 局部内部类与匿名内部类的创建进行了比较.
 * 
 * 局部内部类和匿名内部类的名字在方法外都是不可见的，为什么我们仍然使用局部内部类
 * 而不使用匿名内部类呢？唯一的理由是，我们需要一个已全命名的构造器，或者要重载构造器，
 * 而匿名内部类只能用于实例初始化。
 * 所以不使用匿名内部类的另一个理由是，需要不止一个该内部类的对象（实例）
 * 
 * */
interface Counter{
	int next();
}

public class LocalInnerClass {
	private int count = 0;
	Counter getCounter(final String name){
		//A local inner class 
		class LocalCounter implements Counter{
			public LocalCounter(){System.out.println("LocalCounter()");}
			@Override
			public int next() {
				System.out.print(name);//access local final
				return count++;
			}
		}
		return new LocalCounter();
	}
	//The same thing with an anonymous inner class:
	Counter getCounter2(final String name){
		return new  Counter(){
			//anonymous inner class cannot have a named constructor,only an instance initializer
			{
				System.out.println("Counter()");
			}
			
			@Override
			public int next() {
				System.out.print(name);//access local final
				return count++;
			}
		};
	}
	
	public static void main(String[] args) {
		LocalInnerClass lic = new LocalInnerClass();
		Counter c1 = lic.getCounter("Local inner "),c2 = lic.getCounter2("Anonymous inner");
		for(int i=0;i<5 ;i++)
			System.out.println(c1.next());
		
		for(int i=0;i<5 ;i++)
			System.out.println(c2.next());
	}

}
