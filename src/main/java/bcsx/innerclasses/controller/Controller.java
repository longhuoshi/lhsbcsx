package bcsx.innerclasses.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * һ���������������¼���ʵ�ʿ��ƿ�ܡ�
 * */

public class Controller {
	private List<Event> eventList = new ArrayList<Event>();
	public void addEvent(Event c){
		eventList.add(c);
		
	}
	public void run(){
		while(eventList.size()>0){
			//����new ArrayList<Event>() �ᱨjava.util.ConcurrentModificationException 
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
