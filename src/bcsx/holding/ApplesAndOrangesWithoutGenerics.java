package bcsx.holding;
/**
 * 使用泛型后：
 * 编译器可以阻止Orange放置到apples中，因此变成了一个编译期错误，而不再是运行时候错误。
 * 
 * */
import java.util.ArrayList;

public class ApplesAndOrangesWithoutGenerics {
	//注解:抑制警告信息
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList<Apple> apples = new ArrayList<Apple>();
		for(int i=0; i<3; i++)
			apples.add(new Apple());
		// Compile-time error:
	    // apples.add(new Orange());
		for(int i=0;i<apples.size();i++)
			System.out.println(apples.get(i).id());
			
		for(Apple apple:apples)
			System.out.println(apple.id());
		
		
	}

}
