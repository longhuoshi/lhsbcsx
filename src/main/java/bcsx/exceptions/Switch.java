package bcsx.exceptions;


/**
 * 12.8使用finally清理。
	对于一些代码，可能会希望无论try块中的异常是否抛出，它们都能得到执行。这通常适用
程序员主动释放内存的情况。为了达到这个效果，可以在异常处理程序后面加上finally子句。
完整的异常处理程序看起来像这样：
try{
}catch(A a){
}catch(B b){
}finally{
}
为了证明finally子句总能运行，可以试试下面这个程序：

12.8.1finally用来做什么
	对于没有垃圾回收和析构函数自动调用机制的语言来说，finally非常重要。它能使程序员保证：
无论try块里发生了什么，内存总能得到释放。但java有垃圾回收机制，所以内存释放不再是问题。
而且，java也没有析构函数可供调用。那么，java在什么情况下才能用到finally呢？
	当要把除内存之外的资源恢复到它们的初始状态时，就要用到finally子句。这种需要清理的资源
包括：已经打开的文件和网络连接，在屏幕上画的图形，甚至可以是外部世界的某个开关，如下面
例子所示：
code Switch.java OnOffException1.java OnOffException2.java,OnOffSwitch.java
程序的目的是确保main()结束的时候开关必须是关闭的，所以在每个try块和异常处理程序的末尾都
加入了对sw.off()方法的调用 。
 * */
public class Switch {
	private boolean state = false;
	public boolean read(){return state;}
	public void on(){
		state = true;
		System.out.println(this);
	}
	public void off(){
		state = false;
		System.out.println(this);
	}
	public String toString(){
		return state ? "on" : "off";
	}

}
