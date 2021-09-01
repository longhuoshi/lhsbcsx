package bcsx.strings;

import java.util.Random;

/**
 * 
 * 如果你要在toString()方法中使用循环，那么最好自己创造一个StringBuilder对象，用它来构造最终的结果。
请参考以下示例：
code UsingStringBuilder.java
最终的结果是用append()语句一点点拼接起来的。如果你想走捷径，例如：append(a+":"+c),那编译器就会掉入陷阱，
从而为你另外创建一个StringBuilder对象处理括号内的字符串操作。
 * */

public class UsingStringBuilder {
	public static Random rand = new Random(47);
	public String toString(){
		StringBuilder result = new StringBuilder("[");
		for(int i=0;i<25;i++){
			result.append(rand.nextInt(100));
			result.append(", ");
		}
		result.delete(result.length()-2, result.length());
		result.append("]");
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		UsingStringBuilder usb = new UsingStringBuilder();
		System.out.println(usb);
	}

}
