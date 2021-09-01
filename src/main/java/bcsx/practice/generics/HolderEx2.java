package main.java.bcsx.practice.generics;

class Robot{
	private String name;
	public Robot(String name){
		this.name = name;
	}
	public String toString(){
		return name;
	}
	
}
public class HolderEx2<T> {
	private T x,y,z;
	public HolderEx2(T x,T y,T z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}

	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
	public T getZ() {
		return z;
	}
	public void setZ(T z) {
		this.z = z;
	}
	public String toString(){
		return x+","+y+","+z;
	}


	public static void main(String[] args) {
		Robot r = new Robot("Dog");
		Robot r2 = new Robot("Cat");
		Robot r3 = new Robot("Cattle");
		
		HolderEx2<Robot> he = new HolderEx2<Robot>(r,r2,r3);
		
		System.out.println("Holding:"+he);
		
	}

}
