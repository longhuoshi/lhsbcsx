package myjava;

//回调接口
interface CallBack2{
	void receiveResult(int result);
}
//提供服务
class OfferServer2{
	private CallBack2 cb;
	//注册回调函数
	public boolean register(CallBack2 cb){
		this.cb = cb;
		return true;
	}

	public void dojob(int num,int num2){
		if(cb !=null){
			//业务逻辑算法
			int result = num + num2;
			//触发回调方法，把处理好的结果发送出去
			cb.receiveResult(result);
		}else{
			System.out.println("请注册回调函数!");
		}
	}
}

//被服务的对象 ，继承回调接口。
class AnyPerson2 implements CallBack2{
	private String name;
	public AnyPerson2(String name,OfferServer2 os){
		this.name = name;
		//服务注册
		os.register(this);
	}

	//接受服务端处理好的结果
	@Override
	public void receiveResult(int result) {
		System.out.println(name+"的成绩是："+result);
	}
}

public class CallBackTest2 {
	public static void main(String[] args) {
		final OfferServer2 os = new OfferServer2();
		os.dojob(2, 66);
		AnyPerson2 student = new AnyPerson2("张三",os);
		os.dojob(2, 66);

	}
}
