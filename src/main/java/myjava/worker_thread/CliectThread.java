package myjava.worker_thread;


import java.util.Random;


/**
 * 是发送工作请求的类。发送工作请求这个行为对应的是实例程序中的一下处理：
 * 1创建request的实例
 * 2将该实例传递给Channel类的putRquest方法
 */
public class CliectThread extends Thread {
	private final Channel channel;
	private static final Random random = new Random();
	public CliectThread(String name,Channel channel){
		super(name);
		this.channel = channel;
	}
	
	public void run(){

		try {
			for(int i=0; true ; i++){
				Request request = new Request(getName(), i);
				channel.putRequest(request);
				Thread.sleep(random.nextInt(1000));
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
