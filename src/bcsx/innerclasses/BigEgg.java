package bcsx.innerclasses;
/**
 * 覆盖内部类不会起任何作用。
 * 这说明两个内部类是完全独立的两个实体，各自在自己的命名空间内。
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
