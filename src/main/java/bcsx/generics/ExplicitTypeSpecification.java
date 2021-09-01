package main.java.bcsx.generics;

import java.util.List;
import java.util.Map;

import main.java.bcsx.net.mindview.util.New;
import main.java.bcsx.typeinfo.Person;
import main.java.bcsx.typeinfo.pets.Pet;

public class ExplicitTypeSpecification {
	static void f(Map<Person,List<Pet>> petPeople){}
	
	public static void main(String[] args) {
		f(New.<Person,List<Pet>>map());
	}

}
