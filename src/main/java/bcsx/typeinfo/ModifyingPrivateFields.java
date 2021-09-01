package bcsx.typeinfo;

import java.lang.reflect.Field;

/**
 * 反射修改变量的值 
 * final variable is safe
 * */

class WithPrivateFinalField{
	private int i = 1;
	private final String s = "I'm totally safe";
	private String s2 = "Am I safe?";
	public String toString(){
		return "i = " + i+ ", " +s +"," + s2;
	}
}

public class ModifyingPrivateFields {

	public static void main(String[] args) throws Exception {
		WithPrivateFinalField pf = new WithPrivateFinalField();
		
		System.out.println(pf);
		
		//修改private variable i 的值 
		Field f =  pf.getClass().getDeclaredField("i");
		f.setAccessible(true);
		System.out.println("f.getInt(pf):"+f.getInt(pf));
		f.setInt(pf, 47);
		System.out.println(pf);
		
		//修改private final variable s的值 
		f = pf.getClass().getDeclaredField("s");
		f.setAccessible(true);
		System.out.println("f.get(pf):"+f.get(pf));
		f.set(pf, "No,you're not!");
		System.out.println(pf);
		
		//修改private variable s2的值 
		f = pf.getClass().getDeclaredField("s2");
		f.setAccessible(true);
		System.out.println("f.get(pf):"+f.get(pf));
		f.set(pf, "No,you're not!");
		System.out.println(pf);
		
		

	}

}
