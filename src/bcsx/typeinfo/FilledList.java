package bcsx.typeinfo;

import java.util.ArrayList;
import java.util.List;
/**
 * 14.2.2 ������Class���á�
 * 
 * */
class CountedInteger{
	private static long counter;
	private  final long id = counter++;
	public CountedInteger(int i){}
	public String toString(){
		return Long.toString(id);
	}
}

public class FilledList<T> {
	private Class<T> type;
	public FilledList(Class<T> type){
		 this.type = type;
	}
	
	public List<T> create(int nElements){
		List<T> result = new ArrayList<T>();
		try {
			for(int i=0;i<nElements;i++)
				result.add(type.newInstance());
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);
		System.out.println(fl.create(15));
		
	}

}
