package bcsx.exceptions;
/**
 * 一种更加简单的丢失异常的方式是从finally子句中返回：
code 
如果运行这个程序，就会看到即使抛出了异常，它也不会产生任何输出。
 * */
public class ExceptionSilence {
	public static void main(String[] args) {
		try{
			throw new RuntimeException();
		}finally{
			return;
		}
	}

}
