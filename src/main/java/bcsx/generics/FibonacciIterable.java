package bcsx.generics;

import java.util.Iterator;

public class FibonacciIterable extends Fibonacci implements Iterable<Integer> {
	private int n;
	public FibonacciIterable(int count){
		this.n = count;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		
		return new Iterator<Integer>() {
			
			@Override
			public void remove() {// Not implemented
		        throw new UnsupportedOperationException();
			}
			
			@Override
			public Integer next() {
				n--;
				return FibonacciIterable.this.next();
			}
			
			@Override
			public boolean hasNext() {
				return n>0;
			}
		};
	}
	
	
	public static void main(String[] args) {
		for(int i:new FibonacciIterable(1000)){
			System.out.print(i+" ");
		}
	}


}
