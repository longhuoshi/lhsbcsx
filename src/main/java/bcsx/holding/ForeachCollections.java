package main.java.bcsx.holding;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
/**
 * Foreach�������
��ĿǰΪֹforeach�﷨��Ҫ�������飬������Ҳ����Ӧ�����κ�Collection����
 * */

public class ForeachCollections {

	public static void main(String[] args) {
		Collection<String> cs = new LinkedList<String>();
		cs.addAll(Arrays.asList("Take the long way home".split(" ")));
		for (String string : cs) {
			System.out.print("'"+string+"' ");
		}
	}

}
