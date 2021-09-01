package main.java.bcsx.generics;

class Manipulator<T>{//给泛型类添加边界才能调用  <T extends HasF>
	private T obj;
	public Manipulator(T t){
		obj = t;
	}
	//Error:cannot find symbol :method f();
	public void manipulate() { 
//		obj.f(); 
	}
}

public class Manipulation {
	public static void main(String[] args) {
		HasF hf = new HasF();
		Manipulator<HasF> manipulator = new Manipulator<HasF>(hf);
		manipulator.manipulate();
	}

}
