package main.java.bcsx.innerclasses;

public class Parcel3 {
	class Contents{
		private int i=11;
		private int value(){return i;}
		
	}
	class Destination{
		private String label;
		Destination(String whereTo){
			this.label = whereTo;
		}
		String readLabel(){
			return label;
		}
	}
	public static void main(String[] args){
		Parcel3 p = new Parcel3();
		Parcel3.Contents pc = p.new Contents();
		Parcel3.Destination pd = p.new Destination("louyixiao");
		
	}

}
