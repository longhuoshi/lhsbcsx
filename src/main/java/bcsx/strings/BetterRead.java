package main.java.bcsx.strings;

import java.util.Scanner;

/**
 * ɨ�����������
 * */

public class BetterRead {

	public static void main(String[] args) {
//		Scanner stdin  = new Scanner(System.in);
		Scanner stdin  = new Scanner(SimpleRead.input);
		String name = stdin.nextLine();
		System.out.println(name);
	    System.out.println(
	      "How old are you? What is your favorite double?");
	    System.out.println("(input: <age> <double>)");
	    int age = stdin.nextInt();
	    double favorite = stdin.nextDouble();
	    System.out.println(age);
	    System.out.println(favorite);
	    System.out.format("Hi %s. \n", name);
	    System.out.format("In 5 years you will be %d. \n", age+5);
	    System.out.format("My favorite double is %f. \n",  favorite/2);
	    
		
	}

}
