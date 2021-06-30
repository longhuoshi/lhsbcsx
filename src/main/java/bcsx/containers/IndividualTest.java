package bcsx.containers;

import bcsx.holding.MapOfList;
import bcsx.typeinfo.pets.Individual;
import bcsx.typeinfo.pets.Pet;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author l
 * @date 2020/10/16 9:56
 * @description
 * 17.9.3 覆盖hashCode()
 */
public class IndividualTest {
    public static void main(String[] args) {
        Set<Individual> pets = new TreeSet<>();
        for (List<? extends Pet> lp :  MapOfList.petPeople.values()){
            for (Pet p : lp)
                pets.add(p);
        }
        System.out.println(pets);
    }
}
