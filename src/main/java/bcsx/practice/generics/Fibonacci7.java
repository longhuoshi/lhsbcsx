// generics/Fibonacci7.java
// TIJ4 Chapter Generics, Exercise 7, page 631
// Use composition instead of inheritance to adapt Fibonacci
// to make it interable.

package main.java.bcsx.practice.generics;

import java.util.Iterator;

import main.java.bcsx.net.mindview.util.Generator;
/**
 * 15.3���ͽӿ�
 * ��ϰ7
 * 
 * */
public class Fibonacci7 implements Generator<Integer>, Iterable<Integer> {
	private int count = 0;
	public Fibonacci7(){}
	private int number = 0;
	public Fibonacci7(int n){
		this.number = n;
	}
	private int fib(int n){
		if(n<2) return 1;
		return fib(n-2)+fib(n-1);
	}

	@Override
	public Integer next() {
		return fib(count++);
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			int n = number;
			@Override
			public boolean hasNext() {
				return n>0;
			}

			@Override
			public Integer next() {
				n--;
				return Fibonacci7.this.next();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}


	public static void main(String[] args) {
		Iterator it = new Fibonacci7(18).iterator();
		while(it.hasNext())
			System.out.print(it.next()+" ");
			
		System.out.println();
		for(Integer i : new Fibonacci7(18))
			System.out.print(i+" ");
		
		System.out.println();
		Fibonacci7 fib = new Fibonacci7();
		for(int i=0;i<18;i++)
			System.out.print(fib.next()+" ");
	}

}
