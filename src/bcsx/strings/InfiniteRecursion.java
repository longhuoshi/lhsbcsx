package bcsx.strings;

import java.util.ArrayList;
import java.util.List;
/**
 * 如果你希望toString()方法打印出对象的内存地址，也许你会考虑用this关键字。
code InfiniteRecursion.java
当你创建了InfiniteRecursion对象，并将其打印出来的时候，你会得到一串非常长的异常。
如果你把InfiniteRecursion对象存到List中，然后打印List，你他会得到同样的异常。其实，
当如下代码运行时：
" InfiniteRecursion address: " + this
	这里发生了自动类型转换，由InfiniteRecursion类型转换成String类型，它怎么转换呢，正是
通过调用this上的toString方法，于是发生了递归调用。
	如果你真的想要打印出对象的内存地址，应该调用Object.toString()方法，这才是负责此任务的方法，
所以你不应该用this,而是应该调用super.toString()方法。
 * */
public class InfiniteRecursion {
	
	public String toString(){
		//递归调用。(this转换字符串，调用toString()方法。)
		return " InfiniteRecursion address: " + this + "\n";
//		return " InfiniteRecursion address: " + super.toString() + "\n";
	}
	
	public static void main(String[] args) {
		List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
		for(int i=0;i<10;i++)
			v.add(new InfiniteRecursion());
		System.out.println(v);
	}

}
