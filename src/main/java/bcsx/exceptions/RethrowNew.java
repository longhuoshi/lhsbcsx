package main.java.bcsx.exceptions;

/**
 * ����fillInStackTrace()�����оͳ����쳣���·������ˡ�
	�п����ڲ����쳣֮���׳���һ���쳣����ô���Ļ����õ���Ч��������ʹ��fillInStackTrace(),
�й�ԭ���쳣���������Ϣ�ᶪʧ��ʣ�µ������µ��׳����йص���Ϣ��
code
����Ǹ��쳣��֪���Լ�����main()������f()һ����֪��
��Զ����Ϊ����ǰһ���쳣��������ģ�����˵Ϊ�쳣�������������ġ����Ƕ���new�ڶ��ϴ����Ķ���
�����������������Զ��������������
 * */

class OneException extends Exception{
	public OneException(String s){super(s);}
}
class TwoException extends Exception{
	public TwoException(String s){super(s);}
}

public class RethrowNew {
	public static void f() throws OneException{
		System.out.println("originating the exception in f()");
		throw new OneException("thrown from f()");
	}
	public static void main(String[] args) {
		try{
			
			try{
				f();
			}catch(OneException e){
				System.out.println("Caught in inner try, e.printStackTrace()");
				e.printStackTrace(System.out);
				throw new TwoException("from inner try");
			}
		}catch(TwoException e){
			System.out.println("Caught in outer try, e.printStackTrace()");
			e.printStackTrace(System.out);
		}
		
	}

}
