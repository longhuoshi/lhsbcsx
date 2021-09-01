package main.java.myjava;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Parent{
	
}

class SonA extends Parent{
	
}
class SonB{
	
}



public class Test {
	public Person person; 
	static void test(Object x){
		
		System.out.println("hello word == Parent.class   	   "+(x.getClass() == Parent.class));
		System.out.println("hello word == SonA.class    	   "+(x.getClass() == SonA.class));
		System.out.println("hello word instanceof Parent 	   "+(x instanceof Parent));
		System.out.println("hello word instanceof SonA   	   "+(x instanceof SonA));
		System.out.println("hello word Parent.class.isInstance "+(Parent.class.isInstance(x)));
		System.out.println("hello word SonA.class.isInstance   "+(SonA.class.isInstance(x)));
		System.out.println("hello word equals(Parent.class)    "+(x.getClass().equals(Parent.class)));
		System.out.println("hello word equals(SonA.class)      "+(x.getClass().equals(SonA.class)));







	}




	
	/**
	 * ��������
	 * @param day �ӻ��ȥ������
	 * @return 
	 */
	public static String currentDatePlus(int day) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, day);
		return sdf.format(cal.getTime());

	}
	
	/**
	 * 判断字符 串是不是数据 
	 * */
	public static boolean isNumeric(String str){  
	    Pattern pattern = Pattern.compile("[0-9]*");  
	    return pattern.matcher(str).matches();     
	}  
	
	public static void main(String[] args) {
		String a="a1234";
		if(isNumeric(a))
			System.out.println("----");

		//int 不足6位在前面补0
		String str = String.format("%06d", Integer.parseInt("123"));
		System.out.println(str);
		
		//string 不足 位在前面补0
		String str2 = String.format("%10s", "abcd").replace(' ', '0');
		System.out.println(str2);
		
		
/*//		
////		test(new Parent());
////		System.out.println(currentDatePlus(-2));
//		String file = "http://txlctest.oss-cn-hangzhou.aliyuncs.com/aliyuncs/resource/2019/09/03/3442834.xls";
////		file = "https://cn.bing.com/th?id=OIP.tCKiObqJCzAmTivIHk71VQHaEt&pid=Api&rs=1";
//		try {
//			
//			URL url = new URL(file);//,"utf-8"
//			InputStream stream = new BufferedInputStream(url.openStream());
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
*/		
//		readFileToMemory("E:\\soft\\ideaIU-2018.2.2.exe");
		
		
	
	}
	public static List<String> list = new ArrayList<String>();
	public static void readFileToMemory(String fileName){
		System.out.println("----memory black hole start-----");
		Runtime run = Runtime.getRuntime();
		System.out.println("JVM�����ڴ���" + run.maxMemory());
		System.out.println("JVM�Ŀ���������" + run.freeMemory());
		
		File file = new File(fileName);
		InputStream in = null;
		try{
			int readSize = 1024*1024*200;
			long readSize2 = readSize;
			while(true){
				in = new FileInputStream(file);
				byte[] b = new byte[readSize];
				int result=0;
				while((result = in.read(b))!=-1){
					list.add(new String(b));
					if(readSize2<=run.freeMemory())
						readSize2 = run.freeMemory();
					System.out.println("JVM�Ŀ���������" + run.freeMemory());
				}
				System.out.println(list.size());

			}
			
		}catch(Exception e){
			
		}
		
		
	}
	
	public static void regexIP(){
		//��ip����
		String str = "192.168.1.4   13.130.1.55 7.13.123.100    127.0.0.1";
		//��0��Ŀ�İѲ���3λ�ģ�����3λ 
		str = str.replaceAll("(\\d+)", "00$1");
		System.out.println(str);
		//��0�󣬷�����Щ���β�ֹ3λ���ص�ǰ������0
		str = str.replaceAll("0*(\\d{3})", "$1");
		System.out.println(str);
		
		String[] ips = str.split(" +");//0�������ո�
		Arrays.sort(ips);
		for(String ip : ips){
			System.out.println(ip);
		}
	}
	

}
