package bcsx.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 15.10 通配符
 *
 * */

public class NonCovariantGenerics {
//	Fruit  f = new Apple();
//	List<Fruit> flist = new ArrayList<Apple>();
	/**
	 * 尽管你在第一次阅读这段代码会认为：“不能将 一个Apple容器赋值给一个Fruit容器”
	 * 别忘了，泛型不仅和容器相关，正确的说法是：“不能把一个涉及Apple的泛型赋给一个涉及Fruit的泛型”
	 * 正确的写法是List<? extends Fruit> flist = new ArrayList<Apple>();
	 *
	 * 真正的问题是我们在谈论容器的类型，而不是容器持有的类型。
	 *容器类型ArrayList<Apple>不能向上转型成List<Fruit>
	 *容器持有类型Apple是可以向上转型成Fruit的。
	 *
	 * next {@link GenericsAndCovariance}
	 * */


}
