package bcsx.exceptions;


/**
 * 12.7 Java标准异常。
	Throwable这个java类被用来表示任何可以作为异常被抛出的类。Throwable对象可分为两种
类型（指从Throwable继承而得到的类型）：Error用来表示编译时和系统错误（除特殊情况外
一般不用你关心）；Exception是可以被抛出的基本类型，在java类库，用户方法以及运行时故障
中都可能抛出Exception型异常。所以Java程序员关心的基类通常是Exception。
	要想对异常有全面的了解，最好去浏览下HTML格式的java文档。你会发现，这些异常除了名称
外其实都差不多。java中异常的数目在持续增加。所使用的第三方类库也有可能有自己的异常。
对异常来说，关键是理解概念以及如何使用。
	异常的基本概念是用名称代替发生的问题，并且异常的名称应该可以望文知意。异常并非全是
在java.lang包里定义的；有些异常是用来支持其他像util，net和io这样的程序包，这些异常可以
通过它们完整名称或者从它们的父类中看出端倪。比如，所有的输入/输出异常都是从
java.io.IOException继承而来的。

12.7.1 特例：RuntimeException
有一个例子：
if(t == null)
	throw new NullPointerException();
如果必须对传递给方法的每个引用都检查其是否为null（因为无法确定调用者是否传入了非法引用）
这听起来着实吓人。幸运的是，这不必由你亲自来做，它属于java的标准运行时检测的一部分。如果
对null引用进行调用，Java会自动抛出NullPointerException异常，所以上述代码是多余，尽管你也许
想要执行其他的检查以确保NullPointerException不会出现。
	属于运行时异常的类型有很多，它们会自动被Java虚拟机抛出，所以不必在异常说明中把它们列出来。
这些异常都是从RuntimeException类继承而来，所以即体现了继承的优点，使用起来也很方便。这构成
了一组具有相同特征和行为的异常类型。并且，也不再需要在异常说明中声明，方法将抛出RuntimeException
类型的异常（或者任何从RuntimeException继承的异常），它们也被称为“不受检查异常”。这种异常
属于错误，将被自动捕获，就不用你亲自动手了。要是自己去检查RuntimeException的话，代码就显得太混乱了。
不过尽管通常不用捕获RuntimeException异常，但还是可以在代码中抛出RuntimeException类型的异常。
	如果不捕获这种类型的异常会发生什么事呢？因为编译器没有在这个问题上对异常说明进行强制检查，
RuntimeException类型的异常也许会穿越所有的执行路径直达main()方法，而不会被捕获。要明白到底
发生了什么，可以试试下面的例子：
bcsx.exceptions NeverCaught.java
可能读者已经发现，RuntimeException(或任何从它继承的异常)是一个特例。对于这种异常类型，
编译器不需要异常说明，其输出被报告给了System.err:

所以答案是：如果RuntimeException没有被捕获而直达main(),那么在程序退出前将调用异常
的printStackTrace()方法。
	请务必记住：只能在代码中忽略RuntimeException（及其子类）类型的异常，其它类型异常的
处理都是由编译器强制实施的。究其原因，RuntimeException代表的是编程错误：
1）无法预料的错误。比如从你控制范围之外传递进来的null引用。
2）作为程序员，应该在代码中进行检查的错误。（比如对于ArrayIndexOutOfBoundsException，
就得注意一下数组大小了。）在一个地方发生的异常，常常会在另一个地方导致错误。
	你会发现在这些情况下使用异常很有好处，它们能给调式带来便利。
	值得注意的是：不应把java的异常处理机制当成是单一用途的工具。是的，它被设计用来
处理一些烦人的运行时错误，这些错误往往是由代码控制能力之外的因素导致的；然而，它对于
发现某些编译器无法检测到的编程错误，也是非常重要的。

 * */

public class NeverCaught {
	
	static void f(){
		throw new RuntimeException("From f()");
	}
	
	static void g(){
		f();
	}
	
	public static void main(String[] args) {
		g();
	}

}
