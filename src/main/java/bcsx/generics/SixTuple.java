package bcsx.generics;

public class SixTuple<A, B> {
	public final A first;
	public final B second;
	public SixTuple(A a,B b){
		this.first = a;
		this.second = b;
	}
	
	public String toString(){
		return first+","+second;
		
	}
}
