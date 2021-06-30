package bcsx.generics;

import java.util.ArrayList;
import java.util.List;
/**
 * previous {@link GenericReading}
 * next {@link  UnboundedWildcards2}
 * 15.10.3 无界通配符
 *
 * 编译器很少关心使用的是原生类型还是<?>。在这些情况中，<?>可以被认为是一种装饰，
 * 但是它仍旧是很有价值的，因为，实际上，他是在声明：“我想用java的泛型来编写这段代码，
 * 我在这里并不是要用原生类型，但是在当前这种情况下，泛型参数可以持有任何类型。”
 *
 * */
public class UnboundedWildcards1 {
	static List list1;
	static List<?> list2;
	static List<? extends Object> list3;
	
	static void assign1(List list){
		list1 = list;
		list2 = list;
		list3 = list;
	}
	
	static void assign2(List<?> list){
		list1 = list;
		list2 = list;
		list3 = list;
	}

	static void assign3(List<? extends Object> list){
		list1 = list;
		list2 = list;
		list3 = list;
	}

	public static void main(String[] args) {

		assign1(new ArrayList());
		assign2(new ArrayList());
		assign3(new ArrayList());

		assign1(new ArrayList<String>());
		assign2(new ArrayList<String>());
		assign3(new ArrayList<String>());
		
		List<?> wildList = new 	ArrayList();
		wildList = new ArrayList<String>();
		
		assign1(wildList);
		assign2(wildList);
		assign3(wildList);


	}

}
