package bcsx.exceptions;

/**
 * ��Ҳ����������������쳣�׳�����û��������򲶻���ʱ
sw.off()�͵ò������á���������finally,ֻҪ��try���е���������Ʒ���һ�����ɣ�
code WithFinally.java
����sw.off()���Ƶ�finally�飬���ұ�֤���κ�����¶��ܵõ�ִ�С�
 * */

public class WithFinally {
	public static Switch sw = new Switch();
	public static void main(String[] args) {
		try {
			sw.on();
			OnOffSwitch.f();
		} catch (OnOffException1 e) {
			System.out.println("OnOffException1");
		} catch (OnOffException2 e) {
			System.out.println("OnOffException2");
		}finally{
			sw.off();
		}
	}

}
