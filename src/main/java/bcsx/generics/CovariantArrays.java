package bcsx.generics;
//下一个 NonCovariantGenerics.java
import java.util.Arrays;

/**
 * 15.10 通配符
 *
 *next {@link NonCovariantGenerics}
 * */

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}
 
public class CovariantArrays {

	public static void main(String[] args) {
		Fruit[] fruit = new Apple[10];   //创建 apple数据赋值给fruit数组引用。
		//可以存apple和apple子类。
		fruit[0] = new Apple();
		fruit[1] = new Jonathan();



	   try {
		   //存fruit及其子类在编译期是允许的，但在运行时拋出异常。
          // *泛型的主要目标之一是将这种错误检测移入到编译期。
	      // Compiler allows you to add Fruit:
		   fruit[2] = new Fruit(); // ArrayStoreException
	    } catch(Exception e) { System.out.println(e); }
	   try {
	      // Compiler allows you to add Fruit:
	      fruit[3] = new Orange(); // ArrayStoreException
	    } catch(Exception e) { System.out.println(e); }
	   
	}



}
