package bcsx.generics;

import java.util.ArrayList;
import java.util.List;
/**
 *5.10.2 逆变
 *
 * previous {@link SuperTypeWildcards}
 * next {@link  GenericReading }
 *
 *
 *你可能 会根据 如何能够向一个泛型类型“写入”（传递给一个方法），以及如何能够从
 * 一个泛型类型中“读取”（从一个方法中返回），来着手思考子类型和超类型边界 。
 * 超类型边界放松 了在可以向方法传递的参数 上所做的限制
 * */
public class GenericWriting {
	static <T> void writeExact(List<T> list,T item){
		list.add(item);
	}
	
	static List<Apple> apples = new ArrayList<Apple>();
	static List<Fruit> fruit = new ArrayList<Fruit>();
	static void f1(){
		writeExact(apples,new Apple());
		writeExact(fruit,new Apple());
	}

	/**
	 * 这里演示了通过 List<? super T> 给list赋予协变的逆变能力。
	 * 表示 list里面存放的是T的某个未知父类。
	 * 这样list就能存放T和T的子类型了。
	 * 因为子类转父类是自动进行的。
	 * */
	static <T> void writeWithWildcard(List<? super T> list,T item){
		list.add(item);
	}

	static void f2(){
		writeWithWildcard(apples,new Apple());
		writeWithWildcard(fruit,new Apple());
		
	}
	
	public static void main(String[] args) {
		System.out.println("hello");
		f1();
		f2();
	}

}
