package bcsx.generics;
//下一个 NonCovariantmain.java.generics.java
import java.util.Arrays;

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}
 
public class CovariantArrays {

	public static void main(String[] args) {
		Fruit[] fruit = new Apple[10];
		fruit[0] = new Apple();
		fruit[1] = new Jonathan();
		
		
	   try {
	      // Compiler allows you to add Fruit:
		   fruit[2] = new Fruit(); // ArrayStoreException
	    } catch(Exception e) { System.out.println(e); }
	   try {
	      // Compiler allows you to add Fruit:
	      fruit[3] = new Fruit(); // ArrayStoreException
	    } catch(Exception e) { System.out.println(e); }
	   
	}

}
