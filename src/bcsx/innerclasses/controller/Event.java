package bcsx.innerclasses.controller;
/**
 * 内部类与控制框架
 * 
 * 接口描述了要控制的事件。因为其默认的行为是基于时间去执行控制，所以使用抽象类代替实际的接口。
下面的例子包含了某些实现：
 * */
public abstract class Event {
	private long eventTime;
	protected final long delayTime;
	public Event(long delayTime){
		this.delayTime = delayTime;
		start();
	}
	public void start() {//Allows restarting
		eventTime = System.nanoTime() + delayTime;
		
	}
	
	public boolean ready(){
		return System.nanoTime() >= eventTime;
	}
	
	public abstract void action();
	
}
