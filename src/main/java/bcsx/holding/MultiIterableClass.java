package bcsx.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/**
 * 	ͨ�����ַ�ʽ���ҿ�����IterableClass.javaʾ�����������������������
code
�������������Կ�����Collections.shuffle()����û��Ӱ�쵽ԭ�������飬��ֻ��
������shuffled�е����á�֮����������ֻ����Ϊrandomized()������һ��ArrayList��
Arrays.asList()�����Ľ����װ��������������Arrays.asList()��ȥ������List��
ֱ�Ӵ��ң���ô�����޸ĵײ������
 * */
public class MultiIterableClass extends IterableClass {
	
	//�������
	public Iterable<String> reversed(){
		return new Iterable<String>() {
			
			@Override
			public Iterator<String> iterator() {
				return new Iterator<String>() {
					private int current = words.length -1;
					@Override
					public boolean hasNext() {
						return current>-1;
					}
					@Override
					public String next() {
						return words[current--];
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
	
	
	//�������
	public Iterable<String> randomized(){
		return new Iterable<String>() {
			
			@Override
			public Iterator<String> iterator() {
				//��ArrayList()����������Ϊ�˲�Ӱ��ԭʼwords��˳��
				List<String> list = new ArrayList<String>(Arrays.asList(words));
				Collections.shuffle(list,new Random(47));
				return list.iterator();
			}
		};
	}
	
	public static void main(String[] args) {
		MultiIterableClass mic = new MultiIterableClass();
		for (String s : mic) {
			System.out.print(s + " ");
			
		}
		System.out.println();
		for (String string : mic.randomized()) {
			System.out.print(string + " ");
		}
		System.out.println();
		for (String s : mic.reversed()) {
			System.out.print(s + " ");
			
		}
	}

}
