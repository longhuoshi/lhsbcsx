package bcsx.exceptions;

/**
 * �ź����ǣ�java���쳣ʵ��Ҳ��覴á��쳣��Ϊ�������ı�־������Ӧ�ñ����ԣ���������
�п��ܱ����׵غ��ԡ���ĳЩ����ķ�ʽʹ��finally�Ӿ䣬�ͻᷢ�����������
code 
������п��Կ���VeryImportantException�����ˣ�����finally�Ӿ����HoHumException��ȡ����
�����൱���ص�ȱ�ݣ���Ϊ�쳣���ܻ���һ�ֱ�ǰ��������ʾ��΢������Բ���ķ�ʽ��ȫ��ʧ��
���֮�£�c++�ѡ�ǰһ���쳣��û������׳���һ���쳣�������ο��������ı�̴���Ҳ����
java��δ���汾�л�����������⣨��һ���棬Ҫ�������׳��쳣�ķ������������е�dispose()
������ȫ������ŵ�try-catch�Ӿ����棩��
 * */

class VeryImportantException extends Exception{
	public String toString(){
		return "A very important exception!";
	}
}
class HoHumException extends Exception{
	public String toString(){
		return "A trivial exception!";
	}
}

public class LostMessage {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}
	void dispose() throws HoHumException {
		throw new HoHumException();
	}
	
	public static void main(String[] args) {
		LostMessage lm = new LostMessage();
		try{
			try {
				lm.f();
			}finally{
				lm.dispose();
			}
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e);
		}
	}

}
