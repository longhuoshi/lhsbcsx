package main.java.bcsx.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ���һ��Ԫ��
 * 
 * Arrays.asList()
 * ��ײ��ʾ�������飬��˲��ܵ����ߴ硣������Ե���add()��delete()�������ܻ������ı�����ߴ硣
 * �ᱨUnsupported Operation.
 * 
 * Arrays.asList()������������������������List����������������ļ��裬����û��ע���������
 * ����ʲô�������͡���ʱ��ͻ��������⣺
 * 
 * */
class Snow{}
class Powder extends Snow{}
class Light extends Powder{}
class Heavy extends Powder{}
class Crusty extends Snow{}
class Slush extends Snow{}

public class AsListInference {

	public static void main(String[] args) {
		List<Snow> snow1 = Arrays.asList(new Crusty(),new Slush(),new Powder());
		
		// Won't compile:
//		List<Snow> snow2 = Arrays.asList(new Light(),new Heavy());
		// Compiler says:
	    // found   : java.util.List<Powder>
	    // required: java.util.List<Snow>
		
		// Collections.addAll() doesn't get confused:
		List<Snow> snow3 = new ArrayList<Snow>();
		Collections.addAll(snow3, new Light(),new Heavy());
		
		// Give a hint using an
	    // explicit type argument specification:
		List<Snow> snow4 = Arrays.<Snow>asList(new Light(),new Heavy());//��ʾ���Ͳ���˵����
		
		
	}

}
