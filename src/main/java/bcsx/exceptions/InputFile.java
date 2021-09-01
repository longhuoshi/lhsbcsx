package main.java.bcsx.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * ��һ�����Ҫ������Ҫʱ��ѯ���Լ�������쳣�����ˣ����ж����ܱ���ȷ�������𣿡����� ����������
�Ƿǳ���ȫ�ģ����漰������ʱ������ͳ����ˡ���������Ѷ������óɰ�ȫ�ĳ�ʼ״̬���������б��
�����������һ���ļ��������Ķ���ֻ���ڶ���ʹ����ϲ����û������������������֮����ܵ���
���� ������ڹ��������׳����쳣����Щ������ΪҲ��Ͳ������������ˡ�����ζ���ڱ�д������ʱҪ
����ϸ�ġ�
	����Ҳ�����Ϊʹ��finally�Ϳ��Խ�����⡣�����Ⲣ����˼򵥣���Ϊfinally��ÿ�ζ�ִ������
���롣�������������ִ�й����а�;���ϣ�Ҳ��ö����ĳЩ���ֻ�û�б��ɹ�����������Щ������
finally�Ӿ���ȴ��Ҫ������ġ�
	������������У�������һ��InputFile�࣬���ܴ�һ���ļ�����ÿ�ζ�ȡ���е�һ�С�����ʹ����java
��׼����/������е�FileReader��BufferedReader�࣬��Щ��Ļ����÷��ܼ򵥣�����Ӧ�ú��������ף�
code InputFile.java
 * */

public class InputFile {
	private BufferedReader in;
	public InputFile(String fname) throws Exception{
		try {
			in = new BufferedReader(new FileReader(fname));
			//Other code that might throw exceptions
		} catch (FileNotFoundException e) {
		    System.out.println("Could not open " + fname);
		 // Wasn't open, so don't close it
		    throw e;
		}catch(Exception e){
			// All other exceptions must close it
			try{
				in.close();
			}catch(Exception e2){
				System.out.println("in.close() unsuccessful");
			}
			throw e;//Rethrow.
		}finally{
			
		}
		
	}
	
	public String getLine(){
		String s;
		try {
			s = in.readLine();
		} catch (IOException e) {
			throw new RuntimeException("readLine() failed");
		}
		
		return s;
	}
	
	public void dispose(){
		try {
			in.close();
		    System.out.println("dispose() successful");
		} catch (IOException e) {
		    throw new RuntimeException("in.close() failed");
		}
	}
}
