package bcsx.generics;

/**
 * 边界<T extends HasF>声明T必须具有类型HasF或者从HasF导出类型。如果情况确实如此，那么就可以安全的在obj上调用 f()了。
 * 由于有了边界，下面的代码就可以编译了。
 *
 * */
class Manipulator2<T extends HasF> {
	private  T obj;
	public Manipulator2(T x){obj = x;}
	public void manipulate(){obj.f();}
}

class Manipulation2 {
	public static void main(String[] args) {
		HasF hf = new HasF();
		Manipulator2<HasF> manipulator = new Manipulator2<HasF>(hf);
		manipulator.manipulate();
	}

}