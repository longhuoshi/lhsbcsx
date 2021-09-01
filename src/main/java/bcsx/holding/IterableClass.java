package bcsx.holding;

import java.util.Iterator;
/**
 * ֮����Collection�ܹ���foreachһ����������Ϊjava se5�������µı���ΪIterable�Ľӿڣ�
�ýӿڰ�����һ���ܹ�����Iterator��iterator()����������Iterable�ӿڱ�foreach�������������ƶ���
�������㴴�����κ�ʵ��Iterable���࣬�����Խ�������foreach����У�
code
iterator()�������ص���ʵ����Iterator<String>�������ڲ����ʵ�����������ڲ�����Ա�������
�е����е��ʡ�
 * */
public class IterableClass implements Iterable<String> {
	protected String[] words = ("And that is how we know the Earth to be banana-shaped.").split(" ");
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int index = 0;
			@Override
			public boolean hasNext() {
				return index<words.length;
			}

			@Override
			public String next() {
				return words[index++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		for (String s : new IterableClass()) {
			System.out.print(s + " ");
			
		}
	}

}
