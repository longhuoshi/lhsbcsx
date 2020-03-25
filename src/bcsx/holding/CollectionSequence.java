package bcsx.holding;

import java.util.AbstractCollection;
import java.util.Iterator;

import bcsx.typeinfo.pets.*;
/**
 * 如果要用到Iterator功能，通过继承一个持有Pet对象的类来创建一个Collection的实现 。我们必须要实现 Collection的所有方法，
 * 即使我们不需要它。这里就提供 了AbstractCollection类,但无论如何还是要被强制去实现iterator和size()，因为AbstractCollection没有实现
 * ，但AbstractCollection其它方法中又要用到。
 * */
public class CollectionSequence extends AbstractCollection<Pet>{
	private Pet[] pets = Pets.createArray(8);
	public int size(){
		return pets.length;
	}
	
	public Iterator<Pet> iterator(){
		return new Iterator<Pet>() {
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < size();
			}

			@Override
			public Pet next() {
				return pets[index++];
				
			}

			@Override
			public void remove() {// Not implemented
				throw new UnsupportedOperationException();
			}
			
		
		};
	}
	
	public static void main(String[] args) {
		CollectionSequence c = new CollectionSequence();
		InterfaceVsIterator.display(c);
		InterfaceVsIterator.display(c.iterator());
	}

}
