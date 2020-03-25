package bcsx.innerclasses;
/**
 *匿名内部类
 *基类中需要一个有参的构造器
 * 
 * */
public class Parcel8 {
	public Wrapping wrapping(int x){
		return new Wrapping(x){
			public int value(){
				return super.value()*47;
			}
		};
	}
	
	public static void main(String[] args) {
		Parcel8 p = new Parcel8();
		Wrapping w = p.wrapping(10);
		
	}

}
