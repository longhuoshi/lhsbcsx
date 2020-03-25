package myjava;

//�ص��ӿ�
interface CallBack2{
	void receiveResult(int result);
}
//�ṩ����
class OfferServer2{
	private CallBack2 cb;
	//ע��ص�����
	public boolean register(CallBack2 cb){
		this.cb = cb;
		return true;
	}
	
	public void dojob(int num,int num2){
		if(cb !=null){
			//ҵ���߼��㷨 
			int result = num + num2;
			//�����ص��������Ѵ���õĽ�����ͳ�ȥ
			cb.receiveResult(result);
		}else{
			System.out.println("��ע��ص�����!");
		}
	}
}

//������Ķ��� ���̳лص��ӿڡ�
class AnyPerson2 implements CallBack2{
	private String name;
	public AnyPerson2(String name,OfferServer2 os){
		this.name = name;
		//����ע��
		os.register(this);
	}
	
	//���ܷ���˴���õĽ��
	@Override
	public void receiveResult(int result) {
		System.out.println(name+"�ĳɼ��ǣ�"+result);
	}
}

public class CallBackTest2 {
	public static void main(String[] args) {
		final OfferServer2 os = new OfferServer2();
		os.dojob(2, 66);
		AnyPerson2 student = new AnyPerson2("����",os);
		os.dojob(2, 66);
		
	}
}
