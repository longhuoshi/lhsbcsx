package bcsx.holding;


import java.util.Iterator;

import bcsx.typeinfo.pets.*;

/**
 * 从本例中，你可以看到，如果你实现 Collection,就必须 实现iterator()，并且只拿实现iterator()与继承AbstractCollection相比，
 * 花费的代价只有略微减少。但是，如果你的类已经继承了其它的类，那么你就不能再继承AbstractCollecction了。在这种情况下,要实现Collection，
 * 就必须实现该 接口中的所有方法。此时 ，继承并提供创建迭代器的能力就会显得容易得多了 :
 * code
 * 生成Iterator是将队列与消费队列的方法连接在一起耦合度最小的方式，并且与实现Collection相比，它在序列类上所施
 * 加的约束也少得多。
 * 
 * */

class PetSequence{
	protected Pet[] pets = Pets.createArray(8);
}

public class NonCollectionSequence extends PetSequence{
	public Iterator<Pet> iterator(){
		return new Iterator<Pet>() {
			private int index = 0;
			@Override
			public Pet next() {
				return pets[index++];
			}
			@Override
			public boolean hasNext() {
				return index<pets.length;
			}
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		NonCollectionSequence nc = new NonCollectionSequence();
		InterfaceVsIterator.display(nc.iterator());
	}

}
