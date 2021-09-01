package main.java.bcsx.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * �������������÷�
�����һ��Iterable�࣬����Ҫ���һ�ֻ������foreach�����ʹ�������ķ�����
Ӧ����ô���أ����磬������ϣ������ѡ������ǰ�ķ���������ķ������һ������
�б����ֱ�Ӽ̳�����࣬������iterator()��������ֻ���滻���з�����������
ʵ��ѡ��
	һ�ֽ����������ν�����������Ĺ��÷��������������������������ģʽ����Ϊ�����
�ṩ�ض��ӿ�������foreach��䡣������һ���ӿڲ���Ҫ��һ���ӿ�ʱ����д��������
���Խ�����⡣�����ϣ����Ĭ�ϵ�ǰ��������Ļ����ϣ���Ӳ��������������������
����Ҳ���ʹ�ø��ǣ����������һ���ܲ���Iterable����ķ������� �����������foreach
��䡣��������������ʹ�����ǿ����ṩ����ʹ��foreach�ķ�ʽ��
code
���ֱ�ӽ�ral��������foreach����У����õ���Ĭ�ϣ�ǰ�����������������ڸö�����
����reversed()�������ͻ������ͬ����Ϊ��

tip:��ԭ�е�Iterable��ӷ���������Ǿͼ���һ��Iterable���ͣ��ٶ������һ��
�ܲ���Iterable�ķ�����
 * */

class ReversibleArrayList<T> extends ArrayList<T>{
	public ReversibleArrayList(Collection<T> c){ super(c);}
	public Iterable<T> reversed(){
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					private int current = size()-1;
					@Override
					public boolean hasNext() {
						return current>-1;
					}

					@Override
					public T next() {
						return get(current--);
					}

					@Override
					public void remove() {// Not implemented
						throw new UnsupportedOperationException();
						
					}
				};
			}
			
		};
	}
}

public class AdapterMethodIdiom {

	public static void main(String[] args) {
		ReversibleArrayList<String> ral = new ReversibleArrayList<String>(Arrays.asList("To be or not to be".split(" ")));
		for (String string : ral) {
			System.out.print(string+" ");
		}
		System.out.println();
		//���������
		for (String string : ral.reversed()) {
			System.out.print(string+" ");
		}
	}

}
