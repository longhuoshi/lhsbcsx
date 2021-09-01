package main.java.bcsx.exceptions;

class FourException extends Exception{}

/**
 * �������쳣û�б���ǰ���쳣������򲶻������£��쳣�������Ҳ����������һ����쳣����
����֮ǰ��ִ��finally�Ӿ䣺
code AlwaysFinally.java
���漰break��continue����ʱ��finally�Ӿ�Ҳ��õ�ִ�С���ע�⣬�����finally�Ӿ�ʹ�
��ǩ��break��continue���ʹ�ã���java���û��Ҫʹ��goto��� �ˡ�

 * */

public class AlwaysFinally {

	public static void main(String[] args) {
		System.out.println("Entering first try block");
		
		try{
			System.out.println("Entering second try block");
			try{
				throw new FourException();
			}finally{
				System.out.println("finally in 2nd try block");
			}
		}catch(FourException e){
			System.out.println("Caught FourException in 1st try block");
		}
		System.out.println("-------------------------------------------------");
		//���漰break��continue����ʱ��finally�Ӿ�Ҳ��õ�ִ�С�
		for(int i=0 ;i<6;i++){
			try{
				if(i==2)
					continue;
				if(i==5)
					break;
				System.out.print("try:"+i);
			}finally{
				System.out.println("finally:"+i);
			}
		}
		
	}

}
