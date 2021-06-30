//: net/mindview/util/TypeCounter.java
// Counts instances of a type family.
package bcsx.net.mindview.util;
import java.util.*;
/**
 * 14.3.3 递归计数
 * 
 * Counts instances of a type family.
 * Class类的isAssignableFrom是个不常用的方法，感觉这个方法的名字取得不是很好，所以有必要在此解析一下，以免在看源码时产生歧义，这个方法的签名如下：
 * 由方法签名可见是一个本地方法，即C代码编写的。

以下是JDK中的注释：
Determines if the class or interface represented by this Class object is either the same as,  
or is a superclass or superinterface of, the class or interface represented by the specified Class parameter.
It returns true if so; otherwise it returns false.
If this Class object represents a primitive type, this method returns true if the specified Class parameter is exactly this Class object; otherwise it returns false.
意思如下：
有两个Class类型的类象，一个是调用isAssignableFrom方法的类对象（后称对象a），以及方法中作为参数的这个类对象（称之为对象b），这两个对象如果满足以下条件则返回true，否则返回false：
    a对象所对应类信息是b对象所对应的类信息的父类或者是父接口，简单理解即a是b的父类或接口
    a对象所对应类信息与b对象所对应的类信息相同，简单理解即a和b为同一个类或同一个接口
测试代码：
//说明：Protocol是接口，DubboProtocol是Protocol的实现
Class protocolClass = Protocol.class ;   
Class dubboProtocolClass = DubboProtocol.class ;
        
 protocolClass.isAssignableFrom(dubboProtocolClass )) ;   //返回true
 protocolClass.isAssignableFrom(protocolClass )) ;        //返回true
 dubboProtocolClass.isAssignableFrom(protocolClass )) ;   //返回false
 * */

public class TypeCounter extends HashMap<Class<?>, Integer>{
	private Class<?> baseType;
	public TypeCounter(Class<?> baseType){
		this.baseType = baseType;
	}
	
	public void count(Object obj){
		Class<?> type = obj.getClass();
		if(!baseType.isAssignableFrom(type))
			throw new RuntimeException(obj + " incorrect type: "
			        + type + ", should be type or subtype of "+ baseType);
		
		countClass(type);
	}

	private void countClass(Class<?> type) {
		Integer quantity = get(type);
		put(type,quantity == null ? 1 : quantity +1);
		
		Class<?> superClass = type.getSuperclass();
		if(superClass != null && baseType.isAssignableFrom(superClass))
			countClass(superClass);
		
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder("{");
		for(Map.Entry<Class<?>, Integer> pair : entrySet()){
			result.append(pair.getKey().getSimpleName());
			result.append("=");
			result.append(pair.getValue());
			result.append(",");
		}
		result.delete(result.length()-1, result.length());
		result.append("}");
		
		return result.toString();
	}
	
}
