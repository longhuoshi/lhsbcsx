package bcsx.strings;

import java.util.ArrayList;

import bcsx.generics.coffee.Coffee;
import bcsx.generics.coffee.CoffeeGenerator;
/**
 * java中的每个类从根本上都是继承自Object，标准容器类自然也不例外。因此容器类都有toString方法，并且
覆写了该方法，使得它生成的String结果能够表达容器自身，以及容器所包含的对象。例如ArrayList.toString()，
它会遍历ArrayList中包含的所有对象，调用每个元素上的toStrig()方法。
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
