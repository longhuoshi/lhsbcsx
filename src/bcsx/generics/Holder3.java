package bcsx.generics;

import bcsx.typeinfo.pets.Cat;
import bcsx.typeinfo.pets.Dog;
import bcsx.typeinfo.pets.Pet;
import bcsx.typeinfo.pets.Pets;

public class Holder3<H> {
	private H a;
	public Holder3(H a){this.a = a;}
	
	public H getA() {
		return a;
	}
	public void setA(H a) {
		this.a = a;
	}

	public static void main(String[] args) {
		Holder3<Automobile1> h3 = new Holder3<Automobile1>(new Automobile1());
		Automobile1 a = h3.getA();
		
		
	}

}
