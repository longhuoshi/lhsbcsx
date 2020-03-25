package bcsx.holding;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
/**
 * Foreach与迭代器
到目前为止foreach语法主要用于数组，但是它也可以应用于任何Collection对象。
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
