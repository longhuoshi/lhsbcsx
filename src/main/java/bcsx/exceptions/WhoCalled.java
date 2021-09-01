package main.java.bcsx.exceptions;

/**
 * printStackTrace()�������ṩ����Ϣ����ͨ��getStackTrace()������ֱ�ӷ��ʣ��������
������һ����ջ�켣�е�Ԫ�������ɵ����飬����ÿһ��Ԫ�ض���ʾջ�е�һ�塣Ԫ��0��ջ
��Ԫ�أ������ǵ��������е����һ���������ã����Throwable���������׳�֮����������
�е����һ��Ԫ�غ�ջ���ǵ��������еĵ�һ���������á�����ĳ�����һ���򵥵���ʾʾ����
code 
�������ֻ��ӡ�˷���������ʵ���ϻ����Դ�ӡ����StackTraceElement,����������������Ϣ��
 * */

public class WhoCalled {
	static void f(){
		try{
			throw new Exception();
		}catch(Exception e){
			for(StackTraceElement ste : e.getStackTrace()){
				System.out.println(ste.getMethodName());
			}
		}
	}
	
	static void g(){f();}
	static void h(){g();}
	
	public static void main(String[] args) {
		f();
		System.out.println("--------------------------------");
		g();
		System.out.println("--------------------------------");
		h();
	}

}
