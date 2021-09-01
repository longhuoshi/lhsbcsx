package bcsx.strings;

/**
 * String�Դ������һ��������ʽ�����ǡ��滻���������ֻ�滻������ʽ��һ��ƥ��
 * ���Ӵ��������滻����ƥ��ĵط���
 * */

public class Replacing {
	static String s = Splitting.knights;
	public static void main(String[] args) {
		System.out.println(s);
		System.out.println(s.replaceFirst("f\\w+", "located"));
		System.out.println(s.replaceAll("shrubbery|tree|herring", "banana"));
		
	}

}
