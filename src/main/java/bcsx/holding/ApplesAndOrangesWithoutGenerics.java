package bcsx.holding;
/**
 * ʹ�÷��ͺ�
 * ������������ֹOrange���õ�apples�У���˱����һ�������ڴ��󣬶�����������ʱ�����
 * 
 * */
import java.util.ArrayList;

public class ApplesAndOrangesWithoutGenerics {
	//ע��:���ƾ�����Ϣ
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
