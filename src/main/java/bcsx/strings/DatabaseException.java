package bcsx.strings;

/**
 * 13.5.6 String.format()
 * ��ʵ��String.format()�ڲ�����Ҳ�Ǵ��� һ��Formatter���� ��Ȼ���㴫��Ĳ���ת����Formatter��
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
