package bcsx.strings;

/**
 * String自带的最后一个正则表达式工具是”替换“，你可以只替换正则表达式第一个匹配
 * 的子串，或是替换所有匹配的地方。
 * */

public class Replacing {
	static String s = Splitting.knights;
	public static void main(String[] args) {
		System.out.println(s);
		System.out.println(s.replaceFirst("f\\w+", "located"));
		System.out.println(s.replaceAll("shrubbery|tree|herring", "banana"));
		
	}

}
