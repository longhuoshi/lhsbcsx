//: net/mindview/util/New.java
// Utilities to simplify generic container creation
// by using type argument inference.
package bcsx.net.mindview.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/**
 *  ���Ͳ����ƶ� (type argument inference)
 * */
public class New {

	public static <K,V> Map<K, V> map(){
		return new HashMap<K,V>();
	}
	
	public static <T> List<T> list(){
		return new ArrayList<T>();
	}
	public static <E> LinkedList<E> lList(){
		return new LinkedList<E>();
	}
	
	public static <T> Set<T> set(){
		return new HashSet<T>();
	}
	
	public static <T> Queue<T> queue(){
		return new LinkedList<T>();
	}
	
	public static void main(String[] args) {
		Map<String, List<String>> sls = New.map();
		List<String> ls = New.list();
		LinkedList<String> lls = New.lList();
		Set<String> set = New.set();
		Queue<String> queue = New.queue();
		
		
	}

}
