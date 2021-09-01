package main.java.bcsx.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {

	public static void main(String[] args) {
		List<? extends Fruit> flist = new   ArrayList<Apple>();
		/**
		 * List<? extends Fruit>你可以将其读作“具有任何从Fruit继承的类型的列表”。但是，
		 * 这实际上并不意味着这个List将持有任何类型的Fruit。通配符引用的是明确的类型，因此
		 * 它意味着“某种flist引用没有指定的具体类型”。因此这个被赋值的List必须持有诸如Fruit
		 * 或Apple这样的某种指定类型，但是为了向上转型为flist，这个类型是什么并没有人关心。
		 *
		 * */
		//Compile Error :can't add any type of object
//		flist.add(new Apple());
//		flist.add(new Fruit());
//		flist.add(new Object());

		flist.add(null);
		Fruit f = flist.get(0);
		
		//下一页CompilerIntelligence
	}

}
