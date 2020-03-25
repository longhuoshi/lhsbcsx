package bcsx.holding;

import java.util.Iterator;
/**
 * 之所以Collection能够与foreach一起工作，是因为java se5引入了新的被称为Iterable的接口，
该接口包含了一个能够产生Iterator的iterator()方法，并且Iterable接口被foreach用来在序列中移动。
因此如果你创建了任何实现Iterable的类，都可以将它用于foreach语句中：
code
iterator()方法返回的是实现了Iterator<String>的匿名内部类的实例，该匿名内部类可以遍历数组
中的所有单词。
 * */
public class IterableClass implements Iterable<String> {
	protected String[] words = ("And that is how we know the Earth to be banana-shaped.").split(" ");
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int index = 0;
			@Override
			public boolean hasNext() {
				return index<words.length;
			}

			@Override
			public String next() {
				return words[index++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		for (String s : new IterableClass()) {
			System.out.print(s + " ");
			
		}
	}

}
