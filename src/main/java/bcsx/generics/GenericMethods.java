package bcsx.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {
	/**
	 * ע�⣬��ʹ�÷�����ʱ�������ڴ��������ʱ��ָ�����Ͳ�����ֵ����ʹ�÷��ͷ�����ʱ��ͨ������ָ���������ͣ�
	 * ��Ϊ��������Ϊ�����ҳ����� �����͡����Ϊ ���Ͳ����ƶ� (type argument inference)��������ǿ���
	 * �������ͨ����һ������f()�����Ҿͺ�����f()���޴ε����ع���	
	 * */
	public <T> void f(T t){
		System.out.println(t.getClass().getName());
	}
	public <T,A> void f2(T t,A a,Double b){
		System.out.println(t.getClass().getName()+" "+a.getClass().getName()+" "+b.getClass().getName());
	}
	
	public static void main(String[] args){
		GenericMethods gm = new GenericMethods();
		gm.f(" ");
		gm.f(1);
		gm.f(1.0);
		gm.f(1.0F);
		gm.f('c');
		gm.f(gm);
		
		gm.f2("bb", 1, 1.0);
	}
}
