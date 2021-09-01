package main.java.bcsx.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import main.java.bcsx.generics.coffee.Coffee;
import main.java.bcsx.generics.coffee.CoffeeGenerator;
import main.java.bcsx.net.mindview.util.BasicGenerator;
import main.java.bcsx.net.mindview.util.Generator;

public class Generators {
	public static <T> Collection<T> fill(Collection<T> coll,Generator<T> gen,int n){
		for(int i=0;i<n;i++)
			coll.add(gen.next());
		return coll;
	}
	
	
	public static void main(String[] args) {
		Collection<Coffee> coffee = fill(new ArrayList<Coffee>(),new CoffeeGenerator(),4);
		for(Coffee c : coffee){
			System.out.print(c+" ");
		}
		
		System.out.println();
		Collection<Integer> fnumbers = fill(new ArrayList<Integer>(), new Fibonacci(), 12);
		for(Integer i : fnumbers)
			System.out.print(i+" ");

		
	}

}
