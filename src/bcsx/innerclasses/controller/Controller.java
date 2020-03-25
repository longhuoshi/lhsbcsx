package bcsx.innerclasses.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个用来管理并触发事件的实际控制框架。
 * */

public class Controller {
	private List<Event> eventList = new ArrayList<Event>();
	public void addEvent(Event c){
		eventList.add(c);
		
	}
	public void run(){
		while(eventList.size()>0){
			//不加new ArrayList<Event>() 会报java.util.ConcurrentModificationException 
			for(Event e :  new ArrayList<Event>(eventList)){
				if(e.ready()){
					System.out.println(e);
					e.action();
					eventList.remove(e);
				}
			}
		}
	}
}
