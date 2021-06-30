package bcsx.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * 有一点很重要，即你要时刻询问自己“如果异常发生了，所有东西能被正确的清理吗？”尽管 大多数情况下
是非常安全的，但涉及构造器时，问题就出现了。构造器会把对象设置成安全的初始状态，但还会有别的
动作，比如打开一个文件，这样的动作只有在对象使用完毕并且用户调用了特殊的清理方法之后才能得以
清理 。如果在构造器内抛出了异常，这些清理行为也许就不能正常工作了。这意味着在编写构造器时要
格外细心。
	读者也许会认为使用finally就可以解决问题。但问题并非如此简单，因为finally会每次都执行清理
代码。如果构造器在其执行过程中半途而废，也许该对象的某些部分还没有被成功创建，而这些部分在
finally子句中却是要被清理的。
	在下面的例子中，建立了一个InputFile类，它能打开一个文件并且每次读取其中的一行。这里使用了java
标准输入/输出库中的FileReader和BufferedReader类，这些类的基本用法很简单，读者应该很容易明白：
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
