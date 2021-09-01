package main.java.bcsx.exceptions;

/**
 * ͨ�������쳣���͵Ļ���Exception�������������͵��쳣��
catch(Exception e){
	System.out.println("Caught an exception");
}
��ð������ڴ�������б��ĩβ���Է������������������֮ǰ�Ȱ��쳣�����ˡ�
��ΪException�������йص������쳣��Ļ��࣬�����Ậ��̫��������Ϣ��
���������չʾ�����ʹ��Exception���͵ķ�����
 * */

public class ExceptionMethods {

	public static void main(String[] args) {
		try {
			throw new Exception("My Exception");
		} catch (Exception e) {
			System.out.println("caught Exception");
			System.out.println("getMessage():"+e.getMessage());
			System.out.println("getLocalizedMessage():"+e.getLocalizedMessage());
			System.out.println("toString():"+e);
			System.out.println("printStackTrace():");			
			e.printStackTrace(System.out);
		}
	}
}
