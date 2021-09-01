package bcsx.exceptions;
/**
 * һ�ָ��Ӽ򵥵Ķ�ʧ�쳣�ķ�ʽ�Ǵ�finally�Ӿ��з��أ�
code 
�������������򣬾ͻῴ����ʹ�׳����쳣����Ҳ��������κ������
 * */
public class ExceptionSilence {
	public static void main(String[] args) {
		try{
			throw new RuntimeException();
		}finally{
			return;
		}
	}

}
