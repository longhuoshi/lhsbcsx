package main.java.bcsx.typeinfo;

class Candy{
	static{System.out.println("Loading Candy");}
}

class Gum{
	static{System.out.println("Loading Gum");}
}

class Cookie{
	static{System.out.println("Loading Cookie");}
}

public class SweetShop {
	
	public static void main(String[] args){
		System.out.println("inside main");
		new Candy();
		System.out.println("After creating Candy");
		try {
			/**
			 * main.java.bcsx.typeinfo.Gum дȫ�� 
			 * ����ᱨjava.lang.ClassNotFoundException: Gum
			 * */
			Class.forName("main.java.bcsx.typeinfo.Gum");
		} catch (ClassNotFoundException e) {
			System.out.println("Couldn't find Gum");
			e.printStackTrace();
		}
		System.out.println("After Class.forName(\"Gum\")");
		new Cookie();
		System.out.println("After creating Cookie");
		
		
		
	}
}
