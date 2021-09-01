//: strings/JGrep.java
// A very simple version of the "grep" program.
// {Args: JGrep.java "\\b[Ssct]\\w+"}
package main.java.bcsx.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.bcsx.net.mindview.util.TextFile;
/**
 * ��ʾ�������������ʽ��һ���ļ���������ƥ�������
 * 
 * ���������У����洢��һ��arraylist���档
 * ��forѭ���ⴴ��һ���յ�Matcher���� ��
 * Ȼ����reset����ÿ��ΪMatcher����һ�����롣
 * 
 * */
public class JGrep {

	public static void main(String[] args) {
		//������[Ssct]��ͷ�ĵ��ʡ�
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
