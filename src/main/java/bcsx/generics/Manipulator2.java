package main.java.bcsx.generics;

/**
 * 边界<T extends HasF>声明T必须具有类型HasF或者从HasF导出类型。如果情况确实如此，那么就可以安全的在obj上调用 f()了。
 * */
public class Manipulator2<T extends HasF> {
	private  T obj;
	public Manipulator2(T x){obj = x;}
	public void manipulate(){obj.f();}
}
