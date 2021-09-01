package bcsx.innerclasses;

/**
 * �ֲ��ڲ��ࡣ
 * �ֲ��ڲ����������ڲ���Ĵ��������˱Ƚ�.
 * 
 * �ֲ��ڲ���������ڲ���������ڷ����ⶼ�ǲ��ɼ��ģ�Ϊʲô������Ȼʹ�þֲ��ڲ���
 * ����ʹ�������ڲ����أ�Ψһ�������ǣ�������Ҫһ����ȫ�����Ĺ�����������Ҫ���ع�������
 * �������ڲ���ֻ������ʵ����ʼ����
 * ���Բ�ʹ�������ڲ������һ�������ǣ���Ҫ��ֹһ�����ڲ���Ķ���ʵ����
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
