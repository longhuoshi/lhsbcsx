package main.java.bcsx.generics;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *我们可以执行下面这个相同的类型分析 ，作为对协变和通配符的一个复习 。
 * */

public class GenericReading {
	static <T> T readExact(List<T> list){
		return list.get(0);		
	}
	static List<Apple> apples = Arrays.asList(new Apple());
	static List<Fruit> fruit = Arrays.asList(new Fruit());
	
	static void f1(){
		Apple a = readExact(apples);
		Fruit f = readExact(fruit);
		f = readExact(apples);
	}

	// If, however, you have a class, then its type is
	// established when the class is instantiated:
	static class Reader<T>{
		T readExact(List<T> list){
			return list.get(0);
		}
	}
	
	static void f2(){
		Reader<Fruit> reader = new Reader<Fruit>();
		Fruit f = reader.readExact(fruit);
//		Fruit a = reader.readExact(apples);
// Reader<Fruit> is not applicable for the arguments (List<Apple>)
		
	}
	static class CovariantReader<T>{
		/**
		 * 这里演示了通过 List<? extends T> 给list赋予协变能力。
		 * 表示 list里面存放的是T的某个未知子类。
		 * 这样list里返回的元素是T和T的子类型。赋值给T类型是自动向上转换的。
		 * 因为子类转父类是自动进行的。
		 * */
		T readCovariant(List<? extends T> list){
			T item = list.get(0);
			return item;
		}
	}
	static void f3(){
		CovariantReader<Fruit> fruitReader = new CovariantReader<Fruit>();
		Fruit f = fruitReader.readCovariant(fruit);
		Fruit a = fruitReader.readCovariant(apples);
	}
	
	public static void main(String[] args) {
		f1();
		f2();
		f3();
		
	}
	
}















