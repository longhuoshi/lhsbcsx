package bcsx.exceptions;

/**
 * 12.9 �쳣�����ơ�
�����Ƿ�����ʱ��ֻ���׳��ڻ��෽�����쳣˵�����г�����Щ�쳣��������ƺ����ã�
��Ϊ����ζ�ţ�������ʹ�õĴ���Ӧ�õ�������������ʱ��һ���ܹ���������Ȼ������
�������Ļ���������쳣Ҳ�����⡣
code StormyInning.java
��Inning���У����Կ�����������event()�������������׳��쳣����ʵ����û���׳������ַ�ʽ
ʹ����ǿ���û�ȥ��������ڸ��Ǻ��event()�汾�����ӵ��쳣���������ܺ�������ڳ���
����ͬ������������atBat();
	�ӿ�Stormֵ��ע�⣬��Ϊ��������һ����Inning�ж���ķ���event()��һ������Inning�ж���
�ķ���rainHard()���������������׳��µ��쳣RainedOut�����StormyInning������չInning���
ͬʱ��ʵ����Storm�ӿڣ���ôStorm���event�����Ͳ��ܸı���Inning�е�event()�������쳣�ӿڡ�
����Ļ�����ʹ�û����ʱ��Ͳ����ж��Ƿ񲶻�����ȷ���쳣��������Ҳ�ܺ�����Ȼ������ӿ�
�ﶨ��ķ������������ڻ��࣬����rainHard()����ô�˷����׳�ʲô�����쳣��û�����⡣
	�쳣���ƶԹ������������ã������׳�����������쳣���������๹�������쳣˵�������������
���������쳣˵����
	StormyInning.walk()����ͨ�������ԭ������Ϊ�����׳����쳣����Inning.walk()��û��������
�쳣���������������ô���Ļ����Ϳ����ڵ���Inning.walk()��ʱ�������쳣�����ˣ����ҵ�����
�滻��Inning��������Ķ���ʱ����������п��ܻ��׳��쳣�����ǳ����ʧ���ˡ�ͨ��ǿ��������
���ػ��෽�����쳣˵��������Ŀ��滻�Եõ��˱�֤��
	���Ǻ��event()���������������෽�����Բ��׳��κ��쳣����ʹ���ǻ�����������쳣��ͬ������
��Ϊ����ʹ����ķ������׳��쳣��������Ҳ�����ƻ����еĳ�������Ҳû�����⡣���Ƶ��������
��atBat���ϣ����׳�����PopFoul,����쳣�̳��ԡ��ᱻ�����atBat()�׳�����Foul�������������д��
������ͬInning�򽻵������ҵ���������atBat()�Ļ�����ô�϶��ܲ���Foul����PopFoul����Foul����
�����ģ�����쳣�������Ҳ�ܲ���PopFoul��
	�����ڼ̳й����У�����������쳣˵����ǿ��Ҫ�󣬵��쳣˵�����������ڷ������͵�һ���֣�
�����������ɷ����������������������ɵġ���ˣ����ܻ����쳣˵�������ط��������⣬һ������
�ڻ��෽�����쳣˵���е��쳣����һ��������������෽�����쳣˵������ͬ�̳еĹ������Բ�ͬ��
�ڼ̳��У�����ķ����������������������仰˵���ڼ̳к͸��ǵĹ����У�ĳ���ض������ġ��쳣
˵���Ľӿڡ����Ǳ���˶��Ǳ�С�ˡ���������ǡ�� ����ӿ��ڼ̳�ʱ�����෴��
 * */
class BaseballException extends Exception{}
class Foul extends BaseballException{}
class Strike extends BaseballException{}

abstract class Inning {
	public Inning() throws BaseballException{}
	public void event () throws BaseballException{}
	public abstract void atBat() throws Strike,Foul;
	public void walk(){}
}

class StormException extends Exception{}
class RainedOut extends StormException{}

class PopFoul extends Foul{}

interface Storm{
	public void event() throws RainedOut;
	public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm{
	
	public StormyInning () throws RainedOut,BaseballException{
		
	}
	public StormyInning (String s) throws Foul,BaseballException{}
	//Regular methods must conform to base class:
//	public void walk() throws PopFoul {}
	
	//Interface CANNOT add exceptions to existing  methods from the base class:
//	public void event()throws RainedOut{}
	
	//If the method doesn't already exist in the base class, the exception is OK:
	public void rainHard() throws RainedOut{}
	//You can choose to not throw any exceptions, even if the base version does:
	public void event(){}
	
	// Overridden methods can throw inherited exceptions:
	public void atBat() throws PopFoul {}
	
	public static void main(String[] args)  {
		
		try {
			StormyInning si = new StormyInning();
			si.atBat();
		}catch(PopFoul e){
			System.out.println("Pop foul");
		}catch (RainedOut e1) {
			System.out.println("Rained out");
		} catch (BaseballException e1) {
			System.out.println("Generic baseball exception");
		}
	
		// Strike not thrown in derived version.
		try {
			//What happens if you upcast?
			Inning i = new StormyInning();
			i.atBat();
			
			Storm s = new StormyInning();
			s.event();
			//You must catch the exceptions from the base-class version of the method:
		}catch (Strike e) {
			System.out.println("Strike");
		} catch (Foul e) {
			System.out.println("Foul");
		} catch (RainedOut e) {
			System.out.println("Rained out");
		} catch (BaseballException e) {
			System.out.println("Generic baseball exception");
		}
	}
}
