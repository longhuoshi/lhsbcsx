package bcsx.typeinfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import bcsx.typeinfo.interfacea.A;
import bcsx.typeinfo.packageaccess.HiddenC;

/**
 * 14.9 接口与类型信息。
 * 通过 反射可以调用 用类的隐藏方法和私有方法。
 * 
 * 反编译javap -private 类名(类的Class文件名)
 * */

public class HiddenImplementation {
	
	static void callHiddenMethod(Object a,String methodName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method g = a.getClass().getDeclaredMethod(methodName);
		g.setAccessible(true);
		g.invoke(a);
	}
	
	public static void main(String[] args) throws Exception {
		A a = HiddenC.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		//Compile error:cannot find symbol 'C':
		/*if(a instanceof C){
			C c = (C)a;
			c.g();
		}*/
		//Oops! Reflection still allows us to call g();
		callHiddenMethod(a,"g");
		//And even methods that are less accessible
		callHiddenMethod(a,"u");
		callHiddenMethod(a,"v");
		callHiddenMethod(a,"w");
		
		
	}

}
