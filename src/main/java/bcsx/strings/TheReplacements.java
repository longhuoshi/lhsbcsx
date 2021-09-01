package bcsx.strings;

import java.awt.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bcsx.net.mindview.util.TextFile;

/*! Here's a block of text to use as input to
the regular expression matcher. Note that we'll
first extract the block of text by looking for
the special delimiters, then process the
extracted block. !*/

public class TheReplacements {

	public static void main(String[] args) {
		String s = TextFile.read("src\\bcsx\\strings\\TheReplacements.java");
		Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/",Pattern.DOTALL).matcher(s);
		if(mInput.find())
			s = mInput.group(1);
		//���������������ϵĿո��滻��һ���ո� ��
		s = s.replaceAll(" {2,}", " ");
		//ȥ��ÿ�п�ͷ�Ŀո� ��
		s = s.replaceAll("(?m)^ +","");
		System.out.println(s);
		s = s.replaceFirst("[aeiou]", "(VOWEL1)");
		System.out.println(s);
		StringBuffer sbuf = new StringBuffer();
		Pattern p = Pattern.compile("[aeiou]");
		Matcher m = p.matcher(s);
		while(m.find())
			m.appendReplacement(sbuf, m.group().toUpperCase());//��ƥ�䵽���ַ���������ת���ɴ�д���Ƶ�sbuf�С�
		m.appendTail(sbuf);//��������sʣ��Ĳ��ָ��Ƶ�sbuf�С�
		
		System.out.println(sbuf);
		
		
			
		
		
	}

}
