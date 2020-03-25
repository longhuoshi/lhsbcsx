package bcsx.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/**
 * 	通过这种方式，我可以在IterableClass.java示例中添加两种适配器方法：
code
从上面的输出可以看到，Collections.shuffle()方法没有影响到原来的数组，而只是
打乱了shuffled中的引用。之所以这样，只是因为randomized()方法用一个ArrayList将
Arrays.asList()方法的结果包装了起来。如果这个Arrays.asList()就去产生的List被
直接打乱，那么它会修改底层的数组
 * */
public class MultiIterableClass extends IterableClass {
	
	//逆向遍历
	public Iterable<String> reversed(){
		return new Iterable<String>() {
			
			@Override
			public Iterator<String> iterator() {
				return new Iterator<String>() {
					private int current = words.length -1;
					@Override
					public boolean hasNext() {
						return current>-1;
					}
					@Override
					public String next() {
						return words[current--];
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
	
	
	//随机遍历
	public Iterable<String> randomized(){
		return new Iterable<String>() {
			
			@Override
			public Iterator<String> iterator() {
				//用ArrayList()包起来就是为了不影响原始words的顺序
				List<String> list = new ArrayList<String>(Arrays.asList(words));
				Collections.shuffle(list,new Random(47));
				return list.iterator();
			}
		};
	}
	
	public static void main(String[] args) {
		MultiIterableClass mic = new MultiIterableClass();
		for (String s : mic) {
			System.out.print(s + " ");
			
		}
		System.out.println();
		for (String string : mic.randomized()) {
			System.out.print(string + " ");
		}
		System.out.println();
		for (String s : mic.reversed()) {
			System.out.print(s + " ");
			
		}
	}

}
