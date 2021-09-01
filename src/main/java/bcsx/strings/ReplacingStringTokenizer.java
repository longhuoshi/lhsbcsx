package bcsx.strings;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 13.8 StringTokenizer 
 * 在java引用正则表达式(j2se1.4)和Scanner	类(java se5)之前，分割
 * 字符串唯一方法是使用StringTokenizer来分词。
 * */
public class ReplacingStringTokenizer {

	public static void main(String[] args) {
		String input = "But I'm not dead yet! I feel happy!";
		StringTokenizer stoke = new StringTokenizer(input);
		while(stoke.hasMoreElements())
			System.out.print(stoke.nextToken()+" ");
		
		System.out.println();
		System.out.println(Arrays.toString(input.split(" ")));
		
		Scanner scanner = new Scanner(input);
		scanner.useDelimiter(" ");//这钎可以不写，默认的delimiter就是空格
		while(scanner.hasNext()){
			
			System.out.print(scanner.next()+" ");
		}
		
	}

}
