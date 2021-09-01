//: strings/JGrep.java
// A very simple version of the "grep" program.
// {Args: JGrep.java "\\b[Ssct]\\w+"}
package bcsx.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bcsx.net.mindview.util.TextFile;
/**
 * 演示：如何用正则表达式在一个文件进行搜索匹配操作。
 * 
 * 读入所有行，并存储在一个arraylist里面。
 * 在for循环外创建一个空的Matcher对象 。
 * 然后用reset方法每次为Matcher加载一行输入。
 * 
 * */
public class JGrep {

	public static void main(String[] args) {
		//搜索以[Ssct]开头的单词。
		String regex = "\\b[Ssct]\\w+";
		Pattern p = Pattern.compile(regex);
		int index = 0;
		Matcher m = p.matcher("");
		for(String line : new TextFile("src\\bcsx\\strings\\JGrep.java")){
			m.reset(line);
			while(m.find())
				System.out.println(index++ +":"+m.group()+":"+m.start());
			
		}
	}

}
