//: net/mindview/util/TypeCounter.java
// Counts instances of a type family.
package main.java.bcsx.net.mindview.util;
import java.util.*;
/**
 * 14.3.3 �ݹ����
 * 
 * Counts instances of a type family.
 * Class���isAssignableFrom�Ǹ������õķ������о��������������ȡ�ò��Ǻܺã������б�Ҫ�ڴ˽���һ�£������ڿ�Դ��ʱ�������壬���������ǩ�����£�
 * �ɷ���ǩ���ɼ���һ�����ط�������C�����д�ġ�

������JDK�е�ע�ͣ�
Determines if the class or interface represented by this Class object is either the same as,  
or is a superclass or superinterface of, the class or interface represented by the specified Class parameter.
It returns true if so; otherwise it returns false.
If this Class object represents a primitive type, this method returns true if the specified Class parameter is exactly this Class object; otherwise it returns false.
��˼���£�
������Class���͵�����һ���ǵ���isAssignableFrom����������󣨺�ƶ���a�����Լ���������Ϊ�������������󣨳�֮Ϊ����b������������������������������򷵻�true�����򷵻�false��
    a��������Ӧ����Ϣ��b��������Ӧ������Ϣ�ĸ�������Ǹ��ӿڣ�����⼴a��b�ĸ����ӿ�
    a��������Ӧ����Ϣ��b��������Ӧ������Ϣ��ͬ������⼴a��bΪͬһ�����ͬһ���ӿ�
���Դ��룺
//˵����Protocol�ǽӿڣ�DubboProtocol��Protocol��ʵ��
Class protocolClass = Protocol.class ;   
Class dubboProtocolClass = DubboProtocol.class ;
        
 protocolClass.isAssignableFrom(dubboProtocolClass )) ;   //����true
 protocolClass.isAssignableFrom(protocolClass )) ;        //����true
 dubboProtocolClass.isAssignableFrom(protocolClass )) ;   //����false
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
