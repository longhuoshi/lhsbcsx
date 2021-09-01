package main.java.bcsx.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Collection.addAll()�������� һ��Collection����
 * ����Collection���Ͷ�����Collection.addAll()����;
 *
 * */
public class AddingGroups {

	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		Integer[] moreInts = {6,7,8,9,10};
		collection.addAll(Arrays.asList(moreInts));

		Collections.addAll(collection,11,12,13,14,15);
		Collections.addAll(collection,moreInts);

		List<Integer> list = Arrays.asList(16,17,18,19,20);
		list.set(1, 99);

		/**
		 *
		 * ���������ԭ�����£� 
		 ����Arrays.asList()������List��add��remove����ʱ���쳣��������Arrays.asList()
		 ���ص���Arrays���ڲ���ArrayList�� ������java.util.ArrayList��
		 Arrays���ڲ���ArrayList��java.util.ArrayList���Ǽ̳�AbstractList��remove��add�ȷ���
		 AbstractList����Ĭ��throw UnsupportedOperationException���Ҳ����κβ�����
		 java.util.ArrayList��������Щ������Arrays���ڲ���ArrayListû�����£����Ի��׳��쳣���������:
		 List list2 = new ArrayList(list);
		 list2.add(21);
		 * */
		//��ײ��ʾ�������飬��˲��ܵ����ߴ硣������Ե���add()��delete()�������ܻ������ı�����ߴ硣�ᱨUnsupported Operation.
//		list.add(21); //Runtime error because the  underlying array cannot be resized 

		System.out.println(collection);
		System.out.println(list);




	}

}
