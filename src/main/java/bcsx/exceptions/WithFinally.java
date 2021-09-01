package bcsx.exceptions;

/**
 * 但也可能有这种情况：异常抛出，但没被处理程序捕获，这时
sw.off()就得不到调用。但是有了finally,只要把try块中的清理代码移放在一处即可：
code WithFinally.java
这里sw.off()被移到finally块，并且保证在任何情况下都能得到执行。
 * */

public class WithFinally {
	public static Switch sw = new Switch();
	public static void main(String[] args) {
		try {
			sw.on();
			OnOffSwitch.f();
		} catch (OnOffException1 e) {
			System.out.println("OnOffException1");
		} catch (OnOffException2 e) {
			System.out.println("OnOffException2");
		}finally{
			sw.off();
		}
	}

}
