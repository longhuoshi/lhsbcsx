package main.java.bcsx.typeinfo;

import java.util.HashMap;

import main.java.bcsx.typeinfo.pets.Cat;
import main.java.bcsx.typeinfo.pets.Cymric;
import main.java.bcsx.typeinfo.pets.Dog;
import main.java.bcsx.typeinfo.pets.EgyptianMau;
import main.java.bcsx.typeinfo.pets.ForNameCreator;
import main.java.bcsx.typeinfo.pets.Hamster;
import main.java.bcsx.typeinfo.pets.Manx;
import main.java.bcsx.typeinfo.pets.Mouse;
import main.java.bcsx.typeinfo.pets.Mutt;
import main.java.bcsx.typeinfo.pets.Pet;
import main.java.bcsx.typeinfo.pets.PetCreator;
import main.java.bcsx.typeinfo.pets.Pug;
import main.java.bcsx.typeinfo.pets.Rat;
import main.java.bcsx.typeinfo.pets.Rodent;

public class PetCount {
	static class PetCounter extends HashMap<String, Integer> {
		public void count(String type) {
			Integer quantity = get(type);
			if (quantity == null)
				put(type, 1);
			else
				put(type, quantity + 1);
		}
	}

	public static void countPets(PetCreator creator) {
		PetCounter counter = new PetCounter();
		for (Pet pet : creator.createArray(20)) {
			System.out.print(pet.getClass().getSimpleName() + " ");
			if (pet instanceof Pet)
				counter.count("Pet");
			if (pet instanceof Dog)
				counter.count("Dog");
			if (pet instanceof Mutt)
				counter.count("Mutt");
			if (pet instanceof Pug)
				counter.count("Pug");
			if (pet instanceof Cat)
				counter.count("Cat");
			if (pet instanceof EgyptianMau)
				counter.count("EgyptianMau");
			if (pet instanceof Manx)
				counter.count("Manx");
			if (pet instanceof Cymric)
				counter.count("Cymric");
			if (pet instanceof Rodent)
				counter.count("Rodent");
			if (pet instanceof Rat)
				counter.count("Rat");
			if (pet instanceof Mouse)
				counter.count("Mouse");
			if (pet instanceof Hamster)
				counter.count("Hamster");
		}
		System.out.println();
		System.out.println(counter);

	}

	public static void main(String[] args) {
		countPets(new ForNameCreator());
	}

}
