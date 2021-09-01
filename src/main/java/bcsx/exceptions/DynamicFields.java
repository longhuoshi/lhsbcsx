package main.java.bcsx.exceptions;

class DynamicFieldsException extends Exception{}

/**
 * 
 * 12.6.3�쳣��
��������Ҫ�ڲ���һ���쳣���׳���һ���쳣������ϣ����ԭʼ�쳣����Ϣ�����������ⱻ��Ϊ
�쳣������jdk1.4��ǰ������Ա�����Լ���д����������ԭʼ�쳣����Ϣ����������Throwable��
�����ڹ������ж����Խ���һ��cause�����ɣ�������Ϊ���������cause��������ʾԭʼ�쳣��
����ͨ����ԭʼ�쳣���ݸ��µ��쳣��ʹ�ü�ʹ�ڵ�ǰλ�ô������׳����µ��쳣��Ҳͨ������쳣
��׷�ٵ��쳣���������λ�á�
	��Ȥ���ǣ���Throwable�������У�ֻ�����ֻ������쳣���ṩ�˴�cause�����Ĺ�������������error
(����java���������ϵͳ����)��Exception�Լ�RuntimeException�����Ҫ���������͵��쳣����������
Ӧ��ʹ��initCause()���������ǹ�������
	��������������������ʱ��̬����DynamieFieclds��������ֶΡ�
code DynamicFields.java
ÿ��DynamicFields���󶼺���һ�����飬��Ԫ���ǡ��ɶԵĶ��󡱡���һ�������ʾ�ֶα�ʶ����һ���ַ�������
�ڶ�����ʾ�ֶ�ֵ��ֵ�����Ϳ����ǳ�������������������͡������������ʱ��Ҫ�������һ����Ҫ
�����ֶΡ�������setField()������ʱ��������ͼͨ����ʶ�޸������ֶε�ֵ������ͽ�һ���µ�
�ֶΡ�����ֵ���롣����ռ䲻���ˣ�������һ�����������飬����ԭ�������Ԫ�ظ��ƽ�ȥ���������ͼ
Ϊ�ֶ�����һ����ֵ�����׳�һ��DynamicFieldsException�쳣����ͨ��ʹ��initCause()������NullPointerException
�������������ġ�
	���ڷ��ش���setField()����getField()�����Ѵ�λ�õľ�ֵȡ��������������ܻ��׳�NoSuchFieldException�쳣��
����ͻ��˳���Ա������getField()��������ô���������δ�����������׳���NoSuchFieldException�쳣�������
�쳣�Ǵ�setField()�������׳��ģ��������������Ϊ��̴������Ծ�ʹ�ý���cause�����Ĺ�������
NoSuchFieldException�쳣ת��ΪRuntimeException�쳣��
	���ע�⵽��toString()����ʹ����һ��StringBuilder������������ֻҪ���д���ѭ����toString()������
ͨ��������ʹ������
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
	 * ����ֵ�������ؾ�ֵ �����û�о�ֵ������null
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
