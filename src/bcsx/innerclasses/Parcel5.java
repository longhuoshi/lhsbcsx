package bcsx.innerclasses;

/**
 * 展示了在方法的作用域内，创建一个完整的类。这被称作局部内部类。
 * */
public class Parcel5 {
	public Destination destination(String s){
		class PDestination implements Destination{
			private String label;
			private PDestination(String whereTo){
				this.label = whereTo;
			}
			public String readLabel(){return label;}
			
		}
		
		return new PDestination(s);  //向上转型，返回的是Destination引用。
	}
	
	public static void main(String[] args){
		Parcel5 p = new Parcel5();
		Destination d = p.destination("Tasmania");
		
	}
	
}
