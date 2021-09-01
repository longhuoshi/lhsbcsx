package main.java.myjava.worker_thread;

/**
 * 是表示工人线程的类。
 * 1.调用takeRequest方法从Channel的实例中获取一个Request的实例
 * 2.调用Request的实例的execute方法。
 * 工人线程一旦启动后就会一直工作，也就是说，他会反复执行“获取一个新的Request的实例，然后调用它的execute方法”处理
 */
public class WorkerThread extends Thread {
	private final Channel channel;
	public WorkerThread(String name,Channel channel){
		super(name);
		this.channel = channel;
	}
	
	public void run(){
		while(true){
			Request request = channel.takeRequest();
			request.execute();
		}
	}
	
	
}
