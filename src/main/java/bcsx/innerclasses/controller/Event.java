package bcsx.innerclasses.controller;
/**
 * �ڲ�������ƿ��
 * 
 * �ӿ�������Ҫ���Ƶ��¼�����Ϊ��Ĭ�ϵ���Ϊ�ǻ���ʱ��ȥִ�п��ƣ�����ʹ�ó��������ʵ�ʵĽӿڡ�
��������Ӱ�����ĳЩʵ�֣�
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
