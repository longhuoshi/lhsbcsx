package main.java.bcsx.exceptions;
/**
 * 12.11�쳣ƥ��
	�׳��쳣��ʱ���쳣����ϵͳ�ᰴ�մ������д˳���ҳ���������Ĵ�������ҵ�ƥ��Ĵ������֮��
������Ϊ�쳣���õ�����Ȼ��Ͳ��ټ������ҡ�
	���ҵ�ʱ�򲢲�Ҫ���׳����쳣ͬ����������������쳣��ȫƥ�䡣������Ķ���Ҳ����ƥ�������Ĵ���
���򣬾���������
code Human.java
	catch(Annoyance e)�Ჶ��Annoyance�Լ����д����������쳣����һ��ǳ����ã���Ϊ��������ڷ��������
���������쳣�Ļ���ֻҪ�ͻ�����Ա������ǻ����쳣����ô���ǵĴ����������ġ�
 * */
class Annoyance extends Exception{}
class Sneeze extends Annoyance{}

public class Human {
	public static void main(String[] args) {
		// Catch the exact type:
		try {
			throw new Sneeze();
		} catch (Sneeze e) {
			System.out.println("Caught Sneeze");
		}catch(Annoyance e){
			System.out.println("Caught Annoyance");
		}
		
		// Catch the base type:
		try {
			throw new Sneeze();
		} catch (Annoyance e) {
			System.out.println("Caught Annoyance");
		}
	}
}
