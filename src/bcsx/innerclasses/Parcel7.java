package bcsx.innerclasses;

/**
 * 匿名内部类
 * 在这个匿名内部类，使用了默认的构造器来生成Contents.
 * */
public class Parcel7 {
	public Contents contents(){
		return new Contents(){
			private int i=11;
			public int value(){return i;}
		};
	}
	public static void main(String[] args) {
		Parcel7 p = new Parcel7();
		Contents d = p.contents();
	}

}
