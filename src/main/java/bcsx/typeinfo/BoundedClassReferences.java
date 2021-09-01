package main.java.bcsx.typeinfo;

import main.java.bcsx.net.mindview.util.CountingGenerator.String;

public class BoundedClassReferences {

	public static void main(String[] args) {
		Class<? extends Number> bounded = int.class;
		bounded = double.class;
		bounded = Number.class;
		
	}

}
