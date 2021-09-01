package main.java.bcsx.holding;

import java.util.List;
import java.util.ListIterator;

import main.java.bcsx.typeinfo.pets.Pet;
import main.java.bcsx.typeinfo.pets.Pets;

public class ListIteration {

	public static void main(String[] args) {
		List<Pet> pets = Pets.arrayList(8);
		ListIterator<Pet> it = pets.listIterator();
		while(it.hasNext()){
			System.out.print(it.next()+","+it.nextIndex()+","+it.previousIndex()+"; ");
		}
		System.out.println();
		// Backwards:
		while(it.hasPrevious()){
			System.out.print(it.previous().id()+" ");
		}
		System.out.println();
		System.out.println(pets);
		it = pets.listIterator(3);
		
		while(it.hasNext()){
			it.next();
			it.set(Pets.randomPet());//Cymric, Rat, EgyptianMau, Hamster, EgyptianMau,
		}
		System.out.println(pets);
	}
}
