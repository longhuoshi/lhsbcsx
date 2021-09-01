package bcsx.innerclasses;

/**
 * 在匿名类中定义字段时，还能够对其执行初始化操作；
 * */
public class Parcel9 {
	//dest参数引用要定义为final,因为它是在匿名类内部使用的。
	public Destination destination(final String dest){
		return new Destination() {
			private String label = dest;
			@Override
			public String readLabel() {
				return label;
			}
		};
	}
	
	public static void main(String[] args) {
		Parcel9 p = new Parcel9();
		Destination d = p.destination("Tasmania");
	}

}
