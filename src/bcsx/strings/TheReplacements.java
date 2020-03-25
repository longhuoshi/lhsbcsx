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
		//把两个及两个以上的空格替换成一个空格 。
		s = s.replaceAll(" {2,}", " ");
		//去掉每行开头的空格 。
		s = s.replaceAll("(?m)^ +","");
		System.out.println(s);
		s = s.replaceFirst("[aeiou]", "(VOWEL1)");
		System.out.println(s);
		StringBuffer sbuf = new StringBuffer();
		Pattern p = Pattern.compile("[aeiou]");
		Matcher m = p.matcher(s);
		while(m.find())
			m.appendReplacement(sbuf, m.group().toUpperCase());//把匹配到的字符串的内容转换成大写复制到sbuf中。
		m.appendTail(sbuf);//把字条串s剩余的部分复制到sbuf中。
		
		System.out.println(sbuf);
		
		
			
		
		
	}

}
