package bcsx.exceptions;

/**
 * printStackTrace()方法所提供的信息可以通过getStackTrace()方法来直接访问，这个方法
将返回一个由栈轨迹中的元素所构成的数组，其中每一个元素都表示栈中的一桢。元素0是栈
顶元素，并且是调用序列中的最后一个方法调用（这个Throwable被创建和抛出之处）。数组
中的最后一个元素和栈底是调用序列中的第一个方法调用。下面的程序是一个简单的演示示例。
code 
这里，我们只打印了方法名，但实际上还可以打印整个StackTraceElement,它包含其它附件信息。
 * */

public class WhoCalled {
	static void f(){
		try{
			throw new Exception();
		}catch(Exception e){
			for(StackTraceElement ste : e.getStackTrace()){
				System.out.println(ste.getMethodName());
			}
		}
	}
	
	static void g(){f();}
	static void h(){g();}
	
	public static void main(String[] args) {
		f();
		System.out.println("--------------------------------");
		g();
		System.out.println("--------------------------------");
		h();
	}

}
