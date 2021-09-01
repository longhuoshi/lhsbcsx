package main.java.bcsx.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 容器的打印
 * List以特定的顺序保存一组元素
 * Set元素不重复
 * Queue只允许容器的一端插入对象，并从另一端移除对象。
 * Map每个槽内保存了两个对象，即键与之相关联的值。
 * 
 * 知识点
 * 1、HastSet 获取元素最快的方式。（通常你只会关心某事物是否是某个Set的成员 
 * ，而不会关心它在Set出现的顺序。）如果顺序很重要，可以使用TreeSet，它按照
 * 比较结果的升序保存对象。或使用LinkedHashSet，它按照被添加的顺序保存对象。
 * 2、三种基本风格的Map:HashMap,TreeMap和LinkedHashMap。与HashSet
 * 一样,HashMap也提供了最快的查找技术，也没有任何明显的顺序来保存其元素。TreeMap
 * 按照比较结果的升序保存键，而LinkedHashMap则按照插入顺序保存键，同时还
 * 保留了HashMap的查询速度。
 * 
 * */

public class PrintingContainers {
	static Collection fill(Collection<String> collection){
		
		collection.add("rat");
		collection.add("cat");
		collection.add("dog");
		collection.add("dog");
		return collection;
	}
	
	static Map fill(Map<String,String> map){
		map.put("rat", "Fuzzy");
		map.put("cat", "Rags");
		map.put("dog", "Bosco");
		map.put("dog", "Spot");
		return map;
		
	}

	public static void main(String[] args) {
		System.out.println(fill(new ArrayList<String>()));
		System.out.println(fill(new LinkedList<String>()));
		System.out.println(fill(new HashSet<String>()));
		System.out.println(fill(new TreeSet<String>()));
		System.out.println(fill(new LinkedHashSet<String>()));
		
		System.out.println(fill(new HashMap<String,String>()));
		System.out.println(fill(new TreeMap<String,String>()));
		System.out.println(fill(new LinkedHashMap<String,String>()));
		
		
	}

}
