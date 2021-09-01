package bcsx.practice;

import java.util.ArrayList;
import java.util.List;


class Lhs{
	private static int num=0;
	private final int counter = num++;
	public String toString(){
		return "机器人 "+counter+"号";
	}
}


public class FilledListMaker<T> {
	private Class<T> tclass;
	public FilledListMaker(Class<T> c){tclass = c;}
	List<T> create(int n){
		List<T> list = new ArrayList<>();
		for(int i=0;i<n;i++){
			try {
				list.add(tclass.newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	List<T> create(T t,int n){
		List<T> list = new ArrayList<T>();
		for(int i=0;i<n;i++){
			list.add(t);
		}
		return list;
	}
	
	
	public static void main(String[] args) {
//		FilledListMaker<Lhs> stringMaker = new FilledListMaker<Lhs>(Lhs.class);
//		List<Lhs> list = stringMaker.create(4);
		FilledListMaker<String> stringMaker = new FilledListMaker<String>(String.class);
		List<String> list = stringMaker.create("Hello",4);
		System.out.println(list);
		
	}

}
