package bcsx.innerclasses;
/**
 * 用嵌套类来放置测试代码
 * 好处是不用重复编译已经编译过的代码。
 * 这生成了一个独立的类TestBed$Tester。(要运行这个程序，执行java TestBed$Tester即可。)
 * 可以使用这个类来做测试。
 * */
public class TestBed {
	public void f(){System.out.println("f()");}
	
	// 嵌套类
	public static class Tester{
		public static void main(String[] args){
			TestBed t = new TestBed();
			t.f();
		}
	}
}
