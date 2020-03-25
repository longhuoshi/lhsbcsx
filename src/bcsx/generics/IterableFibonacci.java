package bcsx.generics;

import java.util.Iterator;

public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
	private int count;
	public IterableFibonacci(int count){this.count = count;}
	
	@Override
	public Iterator<Integer> iterator() {
		
		return new Iterator<Integer>() {
			int n = count;
			@Override
			public boolean hasNext() {
				return n>0;
			}

			@Override
			public Integer next() {
				n--;
				return IterableFibonacci.this.next();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		for(int num:new IterableFibonacci(18))
			System.out.print(num+" ");
		
	}


}
