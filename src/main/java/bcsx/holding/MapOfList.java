package main.java.bcsx.holding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sun.misc.Cache;
import main.java.bcsx.net.mindview.util.New;
import main.java.bcsx.typeinfo.pets.*;

public class MapOfList {
	public static Map<Person, List<? extends Pet>> petPeople = New.map();//new HashMap<Person, List<? extends Pet>>();
	static{
		petPeople.put(new Person("Dawn"), Arrays.asList(new Cymric("Molly"),new Mutt("Spot")));
		petPeople.put(new Person("Kate"), Arrays.asList(new Cat("Shackleton"),new Cat("Elsie May"),new Dog("Margrett")));
		petPeople.put(new Person("Marilyn"), Arrays.asList(new Pug("Louie"),new Cat("Stanford"),new Cat("Pinkola")));
		petPeople.put(new Person("Luke"), Arrays.asList(new Rat("Fuzzy"),new Rat("Fizzy")));
		petPeople.put(new Person("Isaac"), Arrays.asList(new Rat("Freckly")));
	}
	
	public static void main(String[] args) {
		System.out.println("People:"+petPeople.keySet());
		System.out.println("People:"+petPeople.values());
		System.out.println("------------------------------------------");
		for(Person p : petPeople.keySet()){
			System.out.print(p+" has:");
			for(Pet pet : petPeople.get(p)){
				System.out.print(" "+pet);
				
			}
			System.out.println();
			
		}
		
		
	}

}
