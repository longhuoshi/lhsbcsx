package bcsx.exceptions;

/**
 * 
 * 12.6.2�����׳��쳣��
��ʱ��ϣ���Ѹղ�����쳣�����׳�����������ʹ��Exception���������쳣��ʱ�򡣼�Ȼ�Ѿ�
�õ��˶Ե�ǰ�쳣��������ã�����ֱ�Ӱ��������׳���
catch(Exception e){
	System.out.println("An exception was thrown");
	throw e;
}
�����쳣����쳣�׸���һ�������е��쳣�������ͬһ��try��ĺ���catch�Ӿ佫�����ԡ�
���⣬�쳣�����������Ϣ�����Ա��棬���Ը�һ�������в�����쳣�Ĵ��������Դ�����쳣
�����еõ�������Ϣ��
	���ֻ�ǰѵ�ǰ�쳣���������׳�����ôprintStackTrace()������ʾ�Ľ���ԭ���쳣�׳���ĵ���
ջ��Ϣ�������������׳������Ϣ��Ҫ����������Ϣ�����Ե���fullInStackTrace()�������⽫����
һ��Throwable��������ͨ���ѵ�ǰ����ջ��Ϣ����ԭ���Ǹ��쳣����������ģ�����������
code
����fillInStackTrace()�����оͳ����쳣���·������ˡ�
 * */

public class Rethrowing {
	public static void f() throws Exception{
		System.out.println("originating the exception in f()");
		throw new Exception("thrown from f()");
	}
	
	public static void g() throws Exception{
		try{
			f();
		}catch(Exception e){
			System.out.println("Inside g(),e.printStackTrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	public static void h() throws Exception{
		try{
			f();
		}catch(Exception e){
			System.out.println("Inside h(),e.printStackTrace()");
			e.printStackTrace(System.out);
			throw (Exception)e.fillInStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try{
			g();
		}catch(Exception e){
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
		try{
			h();
		}catch(Exception e){
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
	}

}
