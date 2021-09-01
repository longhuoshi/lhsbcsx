package bcsx.strings;

import java.util.Random;

/**
 * 
 * �����Ҫ��toString()������ʹ��ѭ������ô����Լ�����һ��StringBuilder�����������������յĽ����
��ο�����ʾ����
code UsingStringBuilder.java
���յĽ������append()���һ���ƴ�������ġ���������߽ݾ������磺append(a+":"+c),�Ǳ������ͻ�������壬
�Ӷ�Ϊ�����ⴴ��һ��StringBuilder�����������ڵ��ַ���������
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
