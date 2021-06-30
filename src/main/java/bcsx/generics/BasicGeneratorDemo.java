package bcsx.generics;

import java.util.List;

import bcsx.net.mindview.util.BasicGenerator;
import bcsx.net.mindview.util.Generator;

public class BasicGeneratorDemo {

	public static void main(String[] args) {
		Generator<CountedObject> gen =  new BasicGenerator(CountedObject.class);//BasicGenerator.create(CountedObject.class);
		for(int i=0;i<5;i++){
			System.out.println("  "+gen.next());
		}

	}
}
