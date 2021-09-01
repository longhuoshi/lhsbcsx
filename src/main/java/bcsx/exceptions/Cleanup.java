package bcsx.exceptions;
/**
 * �����ڹ���׶ο��ܻ��׳��쳣������Ҫ��������࣬�ȫ��ʹ�÷�ʽ��ʹ��Ƕ�׵�try�Ӿ䣺
code  Cleanup.java
	����ϸ�۲�������߼�����InputFile����Ĺ��������Լ���try��������Ч���������ʧ�ܣ��������ⲿ
��catch�Ӿ䣬��dispose()�������ᱻ���á����ǣ��������ɹ������ǿ϶���ȷ�������ܹ������������
����֮������������һ���µ�try���顣ִ�������finally���ڲ���try����������������ַ�ʽ�У�finally
�Ӿ��ڹ���ʧ��ʱ�ǲ���ִ�еģ����ڹ���ɹ�ʱ����ִ�С�
 * */
public class Cleanup {
	public static void main(String[] args) {
		try {
			InputFile in = new InputFile("Cleanup.java");
			try{
				String s;
				int i=1;
				while((s=in.getLine()) != null)
					;//Perform line-by-line processing here...
			}catch(Exception e){
		        System.out.println("Caught Exception in main");
				e.printStackTrace(System.out);
			}finally{
				in.dispose();
			}
		} catch (Exception e) {
		      System.out.println("InputFile construction failed");
		}
	}
}
