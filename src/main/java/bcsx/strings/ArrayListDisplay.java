package main.java.bcsx.strings;

import java.util.ArrayList;

import main.java.bcsx.generics.coffee.Coffee;
import main.java.bcsx.generics.coffee.CoffeeGenerator;
/**
 * java�е�ÿ����Ӹ����϶��Ǽ̳���Object����׼��������ȻҲ�����⡣��������඼��toString����������
��д�˸÷�����ʹ�������ɵ�String����ܹ�������������Լ������������Ķ�������ArrayList.toString()��
�������ArrayList�а��������ж��󣬵���ÿ��Ԫ���ϵ�toStrig()������
code ArrayListDisplay.java
 * */
public class ArrayListDisplay {

	public static void main(String[] args) {
		ArrayList<Coffee> coffees = new ArrayList<Coffee>();
		for(Coffee c : new CoffeeGenerator(10))
			coffees.add(c);
		System.out.println(coffees);
	}
}
