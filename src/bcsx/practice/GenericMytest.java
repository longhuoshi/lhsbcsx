package bcsx.practice;

class Generic1<T>{
	T a;
	public Generic1(){
		
	}
	public void setParam(T t){
		this.a = t;
	}
}
class Generic2<T>{
	T a;

	public T getParam(){
		return a;
	}
}
public class GenericMytest {
	
	public void gTest1(){
		Generic1<String> aa = new Generic1<String>();
		aa.setParam("aaa");
	}
	
	
	
	public static void main(String[] args) {


	}
	
}
