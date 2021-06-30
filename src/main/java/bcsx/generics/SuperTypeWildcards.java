package bcsx.generics;

import java.util.ArrayList;
import java.util.List;
/**
 *15.10.2 逆变  <? super MyClass>
 *  * previous {@link Holder}
 *  * next {@link  GenericWriting}
 *
 *
 * 配符上限和通配符下限的简单解释
 * <? extends T>上限通配，表示？是T的一个未知子类。
 * <? super T>下限通配，表示？是T的一个未知父类。
 *
 *
 * 超类型通配符，这里，可以声明通配符是由某个特定的任何基类来界定的，方法是指<? super MyClass>
 *目的，可以安全地传递一个类型对象到泛型类型中。
 *
 * */
public class SuperTypeWildcards {
	//List<? super Apple>  这个边界是“特定类Apple的任何基类 ”
	static void writeTo(List<? super Apple> apples){
		/**
		 * 参数Apple是Apple的某种基类型的List，这样你就知道向其中添加Apple或Apple的子类型是安全的。
		 * */
		apples.add(new Apple());
		apples.add(new Jonathan());
//		apples.add(new Fruit());  //error



	}


}
