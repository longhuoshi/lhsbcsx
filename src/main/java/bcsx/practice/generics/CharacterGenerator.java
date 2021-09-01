package main.java.bcsx.practice.generics;

import java.util.Iterator;
import java.util.Random;

import main.java.bcsx.generics.coffee.Americano;
import main.java.bcsx.net.mindview.util.Generator;

public class CharacterGenerator implements Generator<StoryCharacters>,Iterable<StoryCharacters>{
	private Class types[] = {IronMan.class,CaptainAmerica.class,BlackWidow.class,Loki.class,Thanos.class};
	private Random rand = new Random();
	public CharacterGenerator(){}
	private int count=0;
	public CharacterGenerator(int size){
		this.count = size;
	}
	
	@Override
	public StoryCharacters next() {
		try {
			return (StoryCharacters) types[rand.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	class CharacterIterator implements Iterator<StoryCharacters>{
		int m = count;
		@Override
		public boolean hasNext() {
			return m>0;
		}

		@Override
		public StoryCharacters next() {
			m--;
			return CharacterGenerator.this.next();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	@Override
	public Iterator<StoryCharacters> iterator() {
		return new CharacterIterator();
	}

	public static void main(String[] args) {
		Iterator it = new CharacterGenerator(5).iterator();
		while(it.hasNext())
			System.out.print(it.next()+" ");
		
		System.out.println();
		CharacterGenerator cg = new CharacterGenerator();
		for(int i=0;i<5;i++){
			System.out.print(cg.next()+" ");
		}
	}

}
