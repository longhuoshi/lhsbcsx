package main.java.bcsx.exceptions;

/**
 * 12.12.4 �ѡ��������쳣��ת��Ϊ���������쳣����
���԰ѡ��������쳣����װ��RuntimeException���棬��������
try{
// ...to do something useful
}catch(IDontKnowWhatToDoWithThischeckedException e){
	throw new RuntimeException(e);
}
�����ѡ��������쳣�����ֹ��ܡ����Ρ����Ļ����⿴��ȥ����һ���ð취�����á����¡��쳣��Ҳ����
�����ŵ��������쳣˵�����棬���쳣�����ܱ�֤�㲻�ᶪʧ�κ�ԭʼ�쳣����Ϣ��
	���ּ��ɸ�����һ��ѡ������Բ�дtry-catch�Ӿ���쳣˵����ֱ�Ӻ����쳣���������ŵ���ջ����
��ð�ݡ���ͬʱ����������getCause()���񲢴����ض����쳣������������
code  TurnOffChecking.java
 * */

import java.io.FileNotFoundException;
import java.io.IOException;

class WrapCheckedException{
	void throwRuntimeException(int type){
		try {
			switch(type){
				case 0:throw new FileNotFoundException();
				case 1:throw new IOException();
				case 2:throw new RuntimeException("Where an I?");
				default:return;
			}
		} catch (Exception e) {// Adapt to unchecked:
			throw new RuntimeException(e);
		}
	}
}

class SomeOtherException extends Exception{}

public class TurnOffChecking {

	public static void main(String[] args)  {
		WrapCheckedException wce = new WrapCheckedException();
		//You can call throwRuntimeException() without a try block, and let RuntimeExceptions leave the method:
		wce.throwRuntimeException(3);
		// Or you can choose to catch exceptions:
		for(int i=0;i<4;i++)
			try {
				if(i<3)
					wce.throwRuntimeException(i);
				else
					throw new SomeOtherException();
			} catch (SomeOtherException e) {
				System.out.println("SomeOtherException:"+e);
			}catch(RuntimeException re){
				try{
					throw re.getCause();
				}catch(FileNotFoundException e){
					System.out.println("FileNotFoundException:"+e);
				} catch (IOException e) {
					System.out.println("IOException:"+e);
				}catch (Throwable e) {
					System.out.println("Throwable:"+e);
				}
			}
	}
}
