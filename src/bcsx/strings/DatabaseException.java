package bcsx.strings;

/**
 * 13.5.6 String.format()
 * 其实在String.format()内部，它也是创建 一个Formatter对象 ，然后将你传入的参数转给该Formatter。
 * 
 * */

public class DatabaseException extends Exception {
	public DatabaseException(int transactionID,int queryID,String message){
		super(String.format("(t%d q%d) %s", transactionID,queryID,message));
	}
	
	public static void main(String[] args) {
		try {
			throw new DatabaseException(3, 7, "Write failed");
		} catch (DatabaseException e) {
			System.out.println(e);
		}
	}

}
