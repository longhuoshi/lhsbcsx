package bcsx.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * 适配器方法惯用法
如果有一个Iterable类，你想要添加一种或多种在foreach语句中使用这个类的方法，
应该怎么做呢？例如，假设你希望可以选择以向前的方向或是向后的方向迭代一个单词
列表。如果直接继承这个类，并覆盖iterator()方法，你只能替换现有方法，而不能
实现选择。
	一种解决方案是所谓适配器方法的惯用法。“适配器”部分来自于设计模式。因为你必须
提供特定接口以满足foreach语句。当你有一个接口并需要另一个接口时，编写适配器就
可以解决问题。这里，我希望在默认的前向迭代器的基础上，添加产生反向迭代器的能力。
因此我不能使用覆盖，而是添加另一个能产生Iterable对象的方法，该 对象可以用于foreach
语句。正如你所见，这使得我们可以提供多种使用foreach的方式。
code
如果直接将ral对象置于foreach语句中，将得到（默认）前向迭代器。但是如果在该对象上
调用reversed()方法，就会产生不同的行为。

tip:在原有的Iterable添加反向遍历。那就继续一种Iterable类型，再额外添加一个
能产生Iterable的方法。
 * */

class ReversibleArrayList<T> extends ArrayList<T>{
	public ReversibleArrayList(Collection<T> c){ super(c);}
	public Iterable<T> reversed(){
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					private int current = size()-1;
					@Override
					public boolean hasNext() {
						return current>-1;
					}

					@Override
					public T next() {
						return get(current--);
					}

					@Override
					public void remove() {// Not implemented
						throw new UnsupportedOperationException();
						
					}
				};
			}
			
		};
	}
}

public class AdapterMethodIdiom {

	public static void main(String[] args) {
		ReversibleArrayList<String> ral = new ReversibleArrayList<String>(Arrays.asList("To be or not to be".split(" ")));
		for (String string : ral) {
			System.out.print(string+" ");
		}
		System.out.println();
		//逆向遍历。
		for (String string : ral.reversed()) {
			System.out.print(string+" ");
		}
	}

}
