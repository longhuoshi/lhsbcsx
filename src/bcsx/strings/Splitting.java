package bcsx.strings;
/**
 * String 自带了一个非常有用的正则表达式工具split()方法。其功能 是“将字符串
 * 从正则表达式匹配的地方切开。”
 * String.split()还有一个重载版本，允许你限制字符串分割的次数。
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
