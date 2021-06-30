package bcsx.strings;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * 13.7.2 用正则表达式扫描。
 * 用自定义的正则表达式，进行扫描 ，这在扫描复杂数据的时候非常有胡。
 * 下面例子将扫描 一个防火墙日志文件中记录的威胁数据 :
 * */

public class ThreatAnalyzer {
	static String threatData =
		    "58.27.82.161@02/10/2005\n" +
		    "204.45.234.40@02/11/2005\n" +
		    "58.27.82.161@02/11/2005\n" +
		    "58.27.82.161@02/12/2005\n" +
		    "58.27.82.161@02/12/2005\n" +
		    "[Next log section with different data format]";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(threatData);
		String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@(\\d{2}/\\d{2}/\\d{4})";
		while (scanner.hasNext(pattern)) {
			scanner.next(pattern);
			MatchResult match = scanner.match();
			String ip = match.group(1);
			String date = match.group(2);
			System.out.format("Threat on %s from %s\n", date,ip);
			
			
		}
		
	}


}
