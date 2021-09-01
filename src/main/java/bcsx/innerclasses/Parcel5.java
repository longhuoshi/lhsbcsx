package bcsx.innerclasses;

/**
 * չʾ���ڷ������������ڣ�����һ���������ࡣ�ⱻ�����ֲ��ڲ��ࡣ
 * */
public class Parcel5 {
	public Destination destination(String s){
		class PDestination implements Destination{
			private String label;
			private PDestination(String whereTo){
				this.label = whereTo;
			}
			public String readLabel(){return label;}
			
		}
		
		return new PDestination(s);  //����ת�ͣ����ص���Destination���á�
	}
	
	public static void main(String[] args){
		Parcel5 p = new Parcel5();
		Destination d = p.destination("Tasmania");
		
	}
	
}
