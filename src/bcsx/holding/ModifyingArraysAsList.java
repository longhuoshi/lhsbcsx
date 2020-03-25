package bcsx.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 就像下面这样：
code
意识到Arrays.asList()产生的List对象会使用底层数组作为其物理实现是很重要的。只要你执行
的操作会修改这个List，并且你不想原来的数组被修改，那么你就应该在另一个容器中创建一个副本。
 * */
public class ModifyingArraysAsList {
	public static void main(String[] args) {
		Random rand = new Random(47);
		Integer[] ia = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(ia));//ArrayList包装过的数组
		System.out.println("Before shuffling:"+list1);
		Collections.shuffle(list1,rand);
		System.out.println("After shuffling:"+list1);
		System.out.println("Array:"+Arrays.toString(ia));
		System.out.println("---------------------------------------");
		List<Integer> list2 = Arrays.asList(ia);//没被ArrayList包装过的数组
		System.out.println("Before shuffling:"+list2);
		Collections.shuffle(list2,rand);
		System.out.println("After shuffling:"+list2);
		System.out.println("Array:"+Arrays.toString(ia));
	}

}
