package bcsx.strings;

import java.util.Scanner;

/**
 * Scanner定界符。
 * 默认情况 下，Scanner根据空白字符对输入进行分词 ，但是你可以用正则表达式指定自己所需的定界符。
 * */
public class ScannerDelimiter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner("12, 42, 78, 99, 42");
		scanner.useDelimiter("\\s*,\\s*");
		
		while(scanner.hasNextInt()){
			System.out.println(scanner.nextInt());
		}
	}

}
