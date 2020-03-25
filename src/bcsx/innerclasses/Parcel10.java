package bcsx.innerclasses;
/**
 * 带实例初始化的形式。
 * 对于匿名类而言，实例初始化的实际效果就是构造器。当然它受到了限制--你不能重载实例初始化方法。
 * 
 * 匿名内部类与正规的继承相比有些受限 。因为匿名内部类即可以扩展类，又可以实现接口。
 * 但是不能两者兼备，而且如果 是实现接口 ，也只能实现 一个接口。
 * */
public class Parcel10 {
	
	public Destination destination(final String dest,final float price){
		return new Destination() {
			private int cost;
			//匿名类构造方法(实例初始化)
			{
				cost = Math.round(price);
				if(cost>100)
					System.out.println("Over budget!");
			}
			private String label = dest;
			@Override
			public String readLabel() {
				return label;
			}
		};
	}
	
	public static void main(String[] args) {
		Parcel10 p = new Parcel10();
		p.destination("Tasmania", 99F);
	}

}
