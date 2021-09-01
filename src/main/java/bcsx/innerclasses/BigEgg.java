package bcsx.innerclasses;
/**
 * �����ڲ��಻�����κ����á�
 * ��˵�������ڲ�������ȫ����������ʵ�壬�������Լ��������ռ��ڡ�
 * 
 * */
class Egg{
	private Yolk y;
	protected class Yolk{
		public Yolk(){System.out.println("Egg.Yolk()");}
	}
	
	public Egg(){
		System.out.println("New Egg()");
		y = new Yolk();
	}
}

public class BigEgg extends Egg{
	private Yolk b;
	public class Yolk{
		public Yolk(){
			System.out.println("BigEgg.Yolk()");
		}
	}
	
	public BigEgg(){
		b = new Yolk();
	}
	
	public static void main(String[] args) {
		BigEgg ge = new BigEgg();
		
	}

}
