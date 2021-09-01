package main.java.bcsx.innerclasses;

/**
 * ���������ж����ֶ�ʱ�����ܹ�����ִ�г�ʼ��������
 * */
public class Parcel9 {
	//dest��������Ҫ����Ϊfinal,��Ϊ�������������ڲ�ʹ�õġ�
	public Destination destination(final String dest){
		return new Destination() {
			private String label = dest;
			@Override
			public String readLabel() {
				return label;
			}
		};
	}
	
	public static void main(String[] args) {
		Parcel9 p = new Parcel9();
		Destination d = p.destination("Tasmania");
	}

}
