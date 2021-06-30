package bcsx.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 15.10.1 编译器有多聪明 (协变)
 *
 *  <? extends T>上限通配，表示？是T的一个未知子类。
 *  <? super T>下限通配，表示？是T的一个未知父类。
 * */
//下一页Holder  上一页GenericsAndCovariance
public class CompilerIntelligence {

	public static void main(String[] args) {
		/**
		 *  List<? extends Fruit>  从这个描述里，编译器并不能了解这里需要Fruit的哪个具体子类型，
		 *  因此它不会接受任何类型的Fruit。
		 *
		 *  __编译器将直接拒绝对参数列表中涉及通配符的方法的调用 。
		 *
		 */
		List<? extends Fruit> flist = Arrays.asList(new Apple());  //这里可以接受 Apple对象
//		flist.add(new Apple())  //这里却不能
		Apple a= (Apple) flist.get(0);
		flist.contains(new Apple());  //argument is 'Object'  
		flist.indexOf(new Apple());//argument is 'Object'    

		/**
		 * previous {@link GenericsAndCovariance}
		 * next {@link  Holder}
		 * */
	}

}
