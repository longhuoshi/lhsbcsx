package myjava.worker_thread;

import java.util.Random;

/**
 * 是工作请求的类
 * name字段是发送请求的委托者，number是请求的编号。
 */

public class Request {
	private final String name;
	private final int number;
	private static final Random random = new Random();
	public Request(String name,int number){
		this.name = name;
		this.number = number;
	}
	
	public void execute(){
		System.out.println(Thread.currentThread().getName()+" executes "+this);
		try {
			Thread.sleep(random.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String toString(){
		return "[Request from "+name+" No."+number+"]";
	}
}
