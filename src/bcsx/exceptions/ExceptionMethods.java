package bcsx.exceptions;

/**
 * 通过捕获异常类型的基类Exception来捕获所有类型的异常。
catch(Exception e){
	System.out.println("Caught an exception");
}
最好把它放在处理程序列表的末尾，以防它抢在其他处理程序之前先把异常捕获了。
因为Exception是与编程有关的所有异常类的基类，它不会含有太多具体的信息。
下面的例子展示了如何使用Exception类型的方法：
 * */

public class ExceptionMethods {

	public static void main(String[] args) {
		try {
			throw new Exception("My Exception");
		} catch (Exception e) {
			System.out.println("caught Exception");
			System.out.println("getMessage():"+e.getMessage());
			System.out.println("getLocalizedMessage():"+e.getLocalizedMessage());
			System.out.println("toString():"+e);
			System.out.println("printStackTrace():");			
			e.printStackTrace(System.out);
		}
	}
}
