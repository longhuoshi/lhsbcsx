package bcsx.generics;

import java.util.List;
import java.util.Map;

import bcsx.net.mindview.util.New;
import bcsx.typeinfo.Person;
import bcsx.typeinfo.pets.Pet;

public class ExplicitTypeSpecification {
	static void f(Map<Person,List<Pet>> petPeople){}
	
	public static void main(String[] args) {
		f(New.<Person,List<Pet>>map());
	}

}
