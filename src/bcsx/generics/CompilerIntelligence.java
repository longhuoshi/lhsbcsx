package bcsx.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 15.10.2 逆变 超类型通配符。<? super MyClass>
 *
 *  <? extends T>上限通配，表示？是T的一个未知子类。
 *  <? super T>下限通配，表示？是T的一个未知父类。
 * */
//下一页Holder  上一页GenericsAndCovariance
public class CompilerIntelligence {

	public static void main(String[] args) {

		List<? extends Fruit> flist = Arrays.asList(new Apple());  //这里可以接受 Apple对象
//		flist.add(new Apple())  //这里却不能
		Apple a= (Apple) flist.get(0);
		flist.contains(new Apple());  //argument is 'Object'  
		flist.indexOf(new Apple());//argument is 'Object'    
		
	}

}
