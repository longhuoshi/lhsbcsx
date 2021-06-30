package myjava;

//�ص��ӿ�
interface CallBack{
	void receiveResult(int result);
}

//�ṩ����
class OfferServer{
	//����һ���ص�����
	public void dojob(int num,int num2,CallBack cb){
		//ҵ���߼��㷨 
		int result = num + num2;
		
		//�����ص��������Ѵ���õĽ�����ͳ�ȥ
		cb.receiveResult(result);
	}
}

//������Ķ���
class AnyPerson{
	private String name;
	
	public AnyPerson(String name){
		this.name = name;
	}
	
	//�̳лص��ӿڣ����ܷ���˴���õĽ����
	class JobResult implements CallBack{

		@Override
		public void receiveResult(int result) {
			System.out.println(name+"�ĳɼ��ǣ�"+result);
		}
	}
	
	public void findHelp(int num,int num2){
		//���� ����˶��󣬵Ǽǻص�����
		new OfferServer().dojob(num, num2, new JobResult());
	}
}

public class CallBackTest {

	public static void main(String[] args) {
		AnyPerson student = new AnyPerson("����");
		student.findHelp(2, 5);
		
	}

}
