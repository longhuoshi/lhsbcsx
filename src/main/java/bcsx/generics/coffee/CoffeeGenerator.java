//: generics/coffee/CoffeeGenerator.java
// Generate different types of Coffee:
package main.java.bcsx.generics.coffee;

import java.util.Iterator;
import java.util.Random;

import main.java.bcsx.net.mindview.util.Generator;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
	private Class[] types = { Latte.class, Mocha.class,
		    Cappuccino.class, Americano.class, Breve.class, };
	private Random rand = new Random(47);
	public CoffeeGenerator(){}
	//For iteration
	private int size = 0;
	public CoffeeGenerator(int sz){ size = sz;}

	@Override
	public Coffee next() {
		try {
			return (Coffee)types[rand.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	class CoffeeIterator implements Iterator<Coffee>{
		int count = size;

		@Override
		public boolean hasNext() {
			return count>0;
		}

		@Override
		public Coffee next() {
			count--;
			return CoffeeGenerator.this.next();
		}

		@Override
		public void remove() {// Not implemented
			throw new UnsupportedOperationException();
		}
		
	}
	
	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
		
	}
	public static void main(String[] args){
		CoffeeGenerator gen = new CoffeeGenerator();
		for(int i=0; i<5;i++){
			System.out.print(gen.next()+" ");
		}
		System.out.println();
		for(Coffee c : new CoffeeGenerator(5))
			System.out.print(c+" ");
		System.out.println();
		
		
	}

	
	

}
