package myjava;


//回调接口
interface CallBack{
	void receiveResult(int result);
}

//提供服务
class OfferServer{
	//接受一个回调对象
	public void dojob(int num,int num2,CallBack cb){
		//业务逻辑算法
		int result = num + num2;

		//触发回调方法，把处理好的结果发送出去
		cb.receiveResult(result);
	}
}

//被服务的对象
class AnyPerson{
	private String name;

	public AnyPerson(String name){
		this.name = name;
	}

	//继承回调接口，接受服务端处理好的结果。
	class JobResult implements CallBack{

		@Override
		public void receiveResult(int result) {
			System.out.println(name+"的成绩是："+result);
		}
	}

	public void findHelp(int num,int num2){
		//调用 服务端对象，登记回调函数
		new OfferServer().dojob(num, num2, new JobResult());
	}
}

public class CallBackTest {

	public static void main(String[] args) {
		AnyPerson student = new AnyPerson("张三");
		student.findHelp(2, 5);

	}

}