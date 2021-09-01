package main.java.bcsx.holding;


import java.util.Iterator;

import main.java.bcsx.typeinfo.pets.*;

/**
 * �ӱ����У�����Կ����������ʵ�� Collection,�ͱ��� ʵ��iterator()������ֻ��ʵ��iterator()��̳�AbstractCollection��ȣ�
 * ���ѵĴ���ֻ����΢���١����ǣ����������Ѿ��̳����������࣬��ô��Ͳ����ټ̳�AbstractCollecction�ˡ������������,Ҫʵ��Collection��
 * �ͱ���ʵ�ָ� �ӿ��е����з�������ʱ ���̳в��ṩ�����������������ͻ��Ե����׵ö��� :
 * code
 * ����Iterator�ǽ����������Ѷ��еķ���������һ����϶���С�ķ�ʽ��������ʵ��Collection��ȣ���������������ʩ
 * �ӵ�Լ��Ҳ�ٵöࡣ
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
