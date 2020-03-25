package bcsx.exceptions;

class DynamicFieldsException extends Exception{}

/**
 * 
 * 12.6.3异常链
常常会想要在捕获一个异常后抛出另一个异常，并且希望把原始异常的信息保存下来，这被称为
异常链。在jdk1.4以前，程序员必须自己编写代码来保存原始异常的信息。现在所有Throwable的
子类在构造器中都可以接受一个cause（因由）对象作为参数。这个cause就用来表示原始异常，
这样通过把原始异常传递给新的异常。使得即使在当前位置创建并抛出了新的异常，也通过这个异常
链追踪到异常最初发生的位置。
	有趣的是，在Throwable的子类中，只有三种基本的异常类提供了带cause参数的构造器。它们是error
(用于java虚拟机报告系统错误)、Exception以及RuntimeException。如果要把其它类型的异常链接起来，
应该使用initCause()方法而不是构造器。
	下面例子能让你在运行时动态的向DynamieFieclds对象添加字段。
code DynamicFields.java
每个DynamicFields对象都含有一个数组，其元素是“成对的对象”。第一个对象表示字段标识符（一个字符串），
第二个表示字段值，值的类型可以是除基本类型外的任意类型。当创建对象的时候，要合理估计一下需要
多少字段。当调用setField()方法的时候，它将试图通过标识修改已有字段的值，否则就建一个新的
字段。并把值放入。如果空间不够了，将建立一个更长的数组，并把原来数组的元素复制进去。如果你试图
为字段设置一个空值，将抛出一个DynamicFieldsException异常，它通过使用initCause()方法把NullPointerException
对象插入而建立的。
	至于返回传，setField()将用getField()方法把此位置的旧值取出，这个操作可能会抛出NoSuchFieldException异常。
如果客户端程序员调用了getField()方法，那么他就有责任处理这个可能抛出的NoSuchFieldException异常，但如果
异常是从setField()方法里抛出的，这种情况将被视为编程错误，所以就使用接受cause参数的构造器把
NoSuchFieldException异常转换为RuntimeException异常。
	你会注意到，toString()方法使用了一个StringBuilder来创建其结果。只要你编写设计循环的toString()方法，
通常都会想使用它。
 * */

public class DynamicFields {
	
	private Object[][] fields;
	public DynamicFields(int initialSize){
		fields = new Object[initialSize][2];
		for(int i=0; i<initialSize; i++){
			fields[i] = new Object[]{null,null};
		}
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		for(Object[] obj : fields){
			result.append(obj[0]);
			result.append(":");
			result.append(obj[1]);
			result.append("\n");
		}
		return result.toString();
	}
	
	private int hasField(String id){
		for(int i=0 ;i<fields.length;i++){
			if(id.equals(fields[i][0])){
				return i;
			}
		}
		return -1;
	}
	
	private int getFieldNumber(String id) throws NoSuchFieldException{
		int fieldNum = hasField(id);
		if(fieldNum == -1)
			throw new NoSuchFieldException();
		return fieldNum;
	}
	
	private int makeField(String id){
		for(int i=0;i<fields.length;i++){
			if(fields[i][0]== null){
				fields[i][0] = id;
				return i;
			}
		}
		
		//No empty fields. Add one;
		Object[][] temp = new Object[fields.length+1][2];
		for(int i=0;i<fields.length;i++){
			temp[i] = fields[i];
		}
		for(int i=fields.length;i<temp.length;i++){
			temp[i] = new Object[]{null,null};
		}
		fields = temp;
		// Recursive call with expanded fields:
		return makeField(id);
		
	}
	
	public Object getField(String id) throws NoSuchFieldException{
		return fields[getFieldNumber(id)][1];
	}
	
	/**
	 * 设置值，并返回旧值 。如果没有旧值，返回null
	 * */
	public Object setField(String id,Object value) throws DynamicFieldsException{
		if(value == null){
			DynamicFieldsException dfe = new DynamicFieldsException();
			dfe.initCause(new NullPointerException());
			throw dfe;
		}
		
		int fieldNumber = hasField(id);
		if(fieldNumber == -1)
			fieldNumber =makeField(id);
		
		Object result = null;
		try {
			result =  getField(id);// Get old value
		} catch (NoSuchFieldException e) {
			// Use constructor that takes "cause":
			throw new RuntimeException(e);
		}
		fields[fieldNumber][1] = value;
		return result;
		
	}
	
	public static void main(String[] args) {
		DynamicFields df = new DynamicFields(3);
//		System.out.println(df);
		try {
			df.setField("d", "A value for d");
			df.setField("number", 47);
			df.setField("number2", 48);
			System.out.println(df);
			df.setField("d", "A new value for d");
			df.setField("number3", 11);
			System.out.println("df: "+df);
			System.out.println("df.getField(\"d\") : "+df.getField("d"));
			Object field = df.setField("d", null);
			
			
		}catch (NoSuchFieldException e) {
			e.printStackTrace();
		}catch (DynamicFieldsException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
