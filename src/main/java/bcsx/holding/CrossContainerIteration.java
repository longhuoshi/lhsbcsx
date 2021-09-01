package main.java.bcsx.holding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

import main.java.bcsx.typeinfo.pets.Pet;
import main.java.bcsx.typeinfo.pets.Pets;

/**
 * 现在考虑创建一个display方法，它不必知晓容器的确切类型。
 * 
 * */
public class CrossContainerIteration {

	public static void display(Iterator<Pet> it){
		while(it.hasNext()){
			Pet p =  it.next();
			System.out.print(p.id()+":"+p+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayList<Pet> pets = Pets.arrayList(8);
		LinkedList<Pet> petsLL = new LinkedList<Pet>(pets);
		HashSet<Pet> petsHS = new HashSet<Pet>(pets);
		TreeSet<Pet> petsTS = new TreeSet<Pet>(pets);
		
		display(pets.iterator());
		display(petsLL.iterator());
		display(petsHS.iterator());
		display(petsTS.iterator());
		
	}
}
