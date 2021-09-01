package main.java.bcsx.strings;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 13.8 StringTokenizer 
 * ��java����������ʽ(j2se1.4)��Scanner	��(java se5)֮ǰ���ָ�
 * �ַ���Ψһ������ʹ��StringTokenizer���ִʡ�
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
		scanner.useDelimiter(" ");//��ǥ���Բ�д��Ĭ�ϵ�delimiter���ǿո�
		while(scanner.hasNext()){
			
			System.out.print(scanner.next()+" ");
		}
		
	}

}
