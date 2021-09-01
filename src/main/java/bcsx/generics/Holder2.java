package bcsx.generics;


class Automobile1{}

public class Holder2 {
	private Object a;
	public Holder2(Object a){
		this.a = a;
	}
	public Object getA() {
		return a;
	}
	public void setA(Object a) {
		this.a = a;
	}

	public static void main(String[] args) {
		
		Holder2 h2 = new Holder2(new Automobile1());
		Automobile1 a= (Automobile1) h2.getA();
		h2.setA("Not an automobile");
		String s = (String)h2.getA();
		h2.setA(1); //Autoboxes to Integer
		Integer x = (Integer) h2.getA();
		
	}

}
