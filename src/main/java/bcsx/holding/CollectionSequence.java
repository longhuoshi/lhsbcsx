package main.java.bcsx.holding;

import java.util.AbstractCollection;
import java.util.Iterator;

import main.java.bcsx.typeinfo.pets.*;
/**
 * ���Ҫ�õ�Iterator���ܣ�ͨ���̳�һ������Pet�������������һ��Collection��ʵ�� �����Ǳ���Ҫʵ�� Collection�����з�����
 * ��ʹ���ǲ���Ҫ����������ṩ ��AbstractCollection��,��������λ���Ҫ��ǿ��ȥʵ��iterator��size()����ΪAbstractCollectionû��ʵ��
 * ����AbstractCollection������������Ҫ�õ���
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
