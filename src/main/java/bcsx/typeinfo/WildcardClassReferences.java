package bcsx.typeinfo;

import bcsx.net.mindview.util.CountingGenerator.String;

public class WildcardClassReferences {

	public static void main(String[] args) {
		Class<?> intClass = int.class;
		intClass = double.class;
	
	}
	
}
