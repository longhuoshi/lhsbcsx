package myjava;

import java.util.Timer;
import java.util.TimerTask;


class Person{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class LoopTimer{
	public static Person person = new Person();
	private Timer timer;
	public void testTask(){
		timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("Person's name:"+person.getName());
			}
		}, 0,2*1000);
	}
	
	public void cancel(){
		 timer.cancel();
	}


	
	
	
}

class ChangeTimer{
	private Timer timer;
	private int counter=0;
	
	public void testTask(){
		timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				counter++;
				LoopTimer.person.setName("zhangsan00"+counter);
			}
		},3,2*1000);
	}
	
	public void cancel(){
		 timer.cancel();
	}
	
}


public class AutoMsgSync {
	public static void main(String[] args) {
		System.out.println("==========main start=============");
		LoopTimer lt = new LoopTimer();
		lt.testTask();
		ChangeTimer ct = new ChangeTimer();
		ct.testTask();
		
		System.out.println("==========main end=============");
	}

}
