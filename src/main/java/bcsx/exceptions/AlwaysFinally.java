package bcsx.exceptions;

class FourException extends Exception{}

/**
 * 甚至在异常没有被当前的异常处理程序捕获的情况下，异常处理机制也会跳到更高一层的异常处理
程序之前，执行finally子句：
code AlwaysFinally.java
当涉及break和continue语句的时候，finally子句也会得到执行。请注意，如果把finally子句和带
标签的break及continue配合使用，在java里就没必要使用goto语句 了。

 * */

public class AlwaysFinally {

	public static void main(String[] args) {
		System.out.println("Entering first try block");
		
		try{
			System.out.println("Entering second try block");
			try{
				throw new FourException();
			}finally{
				System.out.println("finally in 2nd try block");
			}
		}catch(FourException e){
			System.out.println("Caught FourException in 1st try block");
		}
		System.out.println("-------------------------------------------------");
		//当涉及break和continue语句的时候，finally子句也会得到执行。
		for(int i=0 ;i<6;i++){
			try{
				if(i==2)
					continue;
				if(i==5)
					break;
				System.out.print("try:"+i);
			}finally{
				System.out.println("finally:"+i);
			}
		}
		
	}

}
