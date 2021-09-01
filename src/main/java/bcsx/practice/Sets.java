//: net/mindview/util/Sets.java
package main.java.bcsx.practice;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Sets {
	public static <T> Set<T> union(Set<T> a,Set<T> b){
		Set<T> result = null;
		if(a instanceof EnumSet){
			/**
			 * ((EnumSet<T>)a).clone();����  
			 * Bound mismatch: The type T is not a valid substitute for the bounded 
			 * parameter <E extends Enum<E>> of the type EnumSet<E>
			 * �������
			 * */
//			result = ((EnumSet<T>)a).clone();  
			result.addAll(b);
			
		}else{
			result = new HashSet<T>(a);
		}
		
		result.addAll(b);
		return result;
	}
	

	
	public static <T> Set<T> intersection(Set<T> a,Set<T> b){
		Set<T> result = new HashSet<T>(a);
		result.retainAll(b);
		return result;
	}
	
	// Subtract subset from superset:
	public static <T> Set<T> difference(Set<T> superset,Set<T> subset){
		Set<T> result = new HashSet<T>(superset);
		result.removeAll(subset);
		return result;
	}
	
	// Reflexive--everything not in the intersection:
	public static <T> Set<T> complement(Set<T> a,Set<T> b){
		return difference(union(a,b),intersection(a,b));
	}
}
