package main.java.bcsx.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * ������LoggingExceptions�����м�¼��־�Ļ�����ʩ���������쳣�����У�ʹ����
��ʹ�õķ�ʽ�ǳ����㣬����˲���Ҫ�ͻ��˳���Ա��Ԥ�Ϳ����������С����Ǹ�
������������������Ҫ����ͼ�¼�����˱�д���쳣��������Ǳ������쳣���������
������־��Ϣ��
 * */

public class LoggingExceptions2 {
	private static Logger logger= Logger.getLogger("LoggingExceptions2");
	static void logException(Exception e){
		StringWriter trace = new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
	public static void main(String[] args) {
		try{
			throw new NullPointerException();
		}catch(Exception e){
			logException(e);
		}
	}

}
