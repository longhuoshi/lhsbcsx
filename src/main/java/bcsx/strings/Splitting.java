package bcsx.strings;
/**
 * String �Դ���һ���ǳ����õ�������ʽ����split()�������书�� �ǡ����ַ���
 * ��������ʽƥ��ĵط��п�����
 * String.split()����һ�����ذ汾�������������ַ����ָ�Ĵ�����
 * */
import java.util.Arrays;

public class Splitting {
	public static String knights = "Then, when you have found the shrubbery, you must " +
		    "cut down the mightiest tree in the forest... " +
		    "with... a herring!";
	public static void split(String regex){
		System.out.println(Arrays.toString(knights.split(regex)));
	}
	public static void main(String[] args) {
		Class  c = Splitting.class;
		Splitting s = new Splitting();
		Class c2 = s.getClass();
		try {
			Class c3 = Class.forName("bcsx.strings.Splitting");
			
			System.out.println(c.getName());
			System.out.println(c2.getCanonicalName());
			System.out.println(c3.getSimpleName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		split(" ");
		split("\\W+");
		split("n\\W+");
	}

}
