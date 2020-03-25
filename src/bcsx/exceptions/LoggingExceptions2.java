package bcsx.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 尽管由LoggingExceptions将所有记录日志的基础设施都构建在异常自身中，使得它
所使用的方式非常方便，并因此不需要客户端程序员干预就可以自行运行。但是更
常见的情形是我们需要捕获和记录其它人编写的异常。因此我们必须在异常处理程序中
生成日志消息。
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
