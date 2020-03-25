package bcsx.exceptions;

/**
 * 12.12.4 把“被检查的异常”转换为“不检查的异常”。
可以把“被检查的异常”包装进RuntimeException里面，就像这样
try{
// ...to do something useful
}catch(IDontKnowWhatToDoWithThischeckedException e){
	throw new RuntimeException(e);
}
如果想把“被检查的异常”这种功能“屏蔽”掉的话，这看上去像是一个好办法。不用“吞下”异常，也不必
把它放到方法的异常说明里面，而异常链还能保证你不会丢失任何原始异常的信息。
	这种技巧给你了一种选择，你可以不写try-catch子句或异常说明，直接忽略异常，让它沿着调用栈往上
“冒泡”。同时，还可以用getCause()捕获并处理特定的异常，就像这样：
code  TurnOffChecking.java
 * */

import java.io.FileNotFoundException;
import java.io.IOException;

class WrapCheckedException{
	void throwRuntimeException(int type){
		try {
			switch(type){
				case 0:throw new FileNotFoundException();
				case 1:throw new IOException();
				case 2:throw new RuntimeException("Where an I?");
				default:return;
			}
		} catch (Exception e) {// Adapt to unchecked:
			throw new RuntimeException(e);
		}
	}
}

class SomeOtherException extends Exception{}

public class TurnOffChecking {

	public static void main(String[] args)  {
		WrapCheckedException wce = new WrapCheckedException();
		//You can call throwRuntimeException() without a try block, and let RuntimeExceptions leave the method:
		wce.throwRuntimeException(3);
		// Or you can choose to catch exceptions:
		for(int i=0;i<4;i++)
			try {
				if(i<3)
					wce.throwRuntimeException(i);
				else
					throw new SomeOtherException();
			} catch (SomeOtherException e) {
				System.out.println("SomeOtherException:"+e);
			}catch(RuntimeException re){
				try{
					throw re.getCause();
				}catch(FileNotFoundException e){
					System.out.println("FileNotFoundException:"+e);
				} catch (IOException e) {
					System.out.println("IOException:"+e);
				}catch (Throwable e) {
					System.out.println("Throwable:"+e);
				}
			}
	}
}
