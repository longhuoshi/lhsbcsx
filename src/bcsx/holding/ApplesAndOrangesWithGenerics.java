package bcsx.holding;
/**
 * 持有对象(java容器类库的基本知识，以及对典型用法的重点介绍)
泛型和类型安全的容器
 * */
import java.util.ArrayList;

class Apple{
	private static long counter;
	private final long id = counter++; 
	public long id(){
		return id;
	}
}
class Orange{}


public class ApplesAndOrangesWithGenerics {
	//注解:抑制警告信息
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList apples = new ArrayList();
		for(int i=0; i<3; i++)
			apples.add(new Apple());
		apples.add(new Orange());
		for(int i=0;i<apples.size();i++)
			((Apple)apples.get(i)).id();
		
	}

}
