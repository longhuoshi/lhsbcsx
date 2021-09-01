package bcsx.innerclasses;
/**
 * ��ʵ����ʼ������ʽ��
 * ������������ԣ�ʵ����ʼ����ʵ��Ч�����ǹ���������Ȼ���ܵ�������--�㲻������ʵ����ʼ��������
 * 
 * �����ڲ���������ļ̳������Щ���� ����Ϊ�����ڲ��༴������չ�࣬�ֿ���ʵ�ֽӿڡ�
 * ���ǲ������߼汸��������� ��ʵ�ֽӿ� ��Ҳֻ��ʵ�� һ���ӿڡ�
 * */
public class Parcel10 {
	
	public Destination destination(final String dest,final float price){
		return new Destination() {
			private int cost;
			//�����๹�췽��(ʵ����ʼ��)
			{
				cost = Math.round(price);
				if(cost>100)
					System.out.println("Over budget!");
			}
			private String label = dest;
			@Override
			public String readLabel() {
				return label;
			}
		};
	}
	
	public static void main(String[] args) {
		Parcel10 p = new Parcel10();
		p.destination("Tasmania", 99F);
	}

}
