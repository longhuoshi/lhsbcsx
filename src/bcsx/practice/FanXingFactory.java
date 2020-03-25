package bcsx.practice;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

interface IFan<T>{
	T create();
}

class FactoryFun<T>{
	public <E extends IFan<T>> FactoryFun(E factory){
		factory.create();
	}
}

class IntegerF implements IFan<Integer>{

	@Override
	public Integer create() {
		return new Integer(0);
	}
}

class Lisa{
	public static class  LisaF implements  IFan<Lisa>{

		@Override
		public Lisa create() {
			return new Lisa();
		}
		
	}
}

public class FanXingFactory {
	public static void main(String[] args) {
		new FactoryFun<Integer>(new IntegerF());
		new FactoryFun<Lisa>(new Lisa.LisaF());
		
	}
}
