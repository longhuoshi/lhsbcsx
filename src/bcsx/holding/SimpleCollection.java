package bcsx.holding;
/**
 * Integer对象填充了一人Collection
 * */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class SimpleCollection {

	public static void main(String[] args) {
		Collection<Integer> c = new ArrayList<Integer>();
//		Collection<Integer> c = new HashSet<Integer>();
		
		for(int i=0; i<10; i++)
			c.add(i);
		
		for(Integer i : c)
			System.out.print(i+",");
	}

}
