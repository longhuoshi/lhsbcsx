package bcsx.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * ��������������
code
��ʶ��Arrays.asList()������List�����ʹ�õײ�������Ϊ������ʵ���Ǻ���Ҫ�ġ�ֻҪ��ִ��
�Ĳ������޸����List�������㲻��ԭ�������鱻�޸ģ���ô���Ӧ������һ�������д���һ��������
 * */
public class ModifyingArraysAsList {
	public static void main(String[] args) {
		Random rand = new Random(47);
		Integer[] ia = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(ia));//ArrayList��װ��������
		System.out.println("Before shuffling:"+list1);
		Collections.shuffle(list1,rand);
		System.out.println("After shuffling:"+list1);
		System.out.println("Array:"+Arrays.toString(ia));
		System.out.println("---------------------------------------");
		List<Integer> list2 = Arrays.asList(ia);//û��ArrayList��װ��������
		System.out.println("Before shuffling:"+list2);
		Collections.shuffle(list2,rand);
		System.out.println("After shuffling:"+list2);
		System.out.println("Array:"+Arrays.toString(ia));
	}

}
