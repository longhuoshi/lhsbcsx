package bcsx.exceptions;
/**
 * 对于在构造阶段可能会抛出异常，并且要求清理的类，最安全的使用方式是使用嵌套的try子句：
code  Cleanup.java
	请仔细观察这里的逻辑：对InputFile对象的构造在其自己的try语句块中有效，如果构造失败，将进入外部
的catch子句，而dispose()方法不会被调用。但是，如果构造成功，我们肯定想确保对象能够被清理，因此在
构造之后立即创建了一个新的try语句块。执行清理的finally与内部的try语句块相关联。在这种方式中，finally
子句在构造失败时是不会执行的，而在构造成功时总是执行。
 * */
public class Cleanup {
	public static void main(String[] args) {
		try {
			InputFile in = new InputFile("Cleanup.java");
			try{
				String s;
				int i=1;
				while((s=in.getLine()) != null)
					;//Perform line-by-line processing here...
			}catch(Exception e){
		        System.out.println("Caught Exception in main");
				e.printStackTrace(System.out);
			}finally{
				in.dispose();
			}
		} catch (Exception e) {
		      System.out.println("InputFile construction failed");
		}
	}
}
