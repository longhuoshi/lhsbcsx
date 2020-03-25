package bcsx.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 添加一组元素
 * 
 * Arrays.asList()
 * 其底层表示的是数组，因此不能调整尺寸。如果尝试调用add()或delete()方法可能会引发改变数组尺寸。
 * 会报Unsupported Operation.
 * 
 * Arrays.asList()方法的限制是它对所产生的List类型做出了最理想的假设，而并没有注意你对它会
 * 赋予什么样的类型。有时这就会引发问题：
 * 
 * */
class Snow{}
class Powder extends Snow{}
class Light extends Powder{}
class Heavy extends Powder{}
class Crusty extends Snow{}
class Slush extends Snow{}

public class AsListInference {

	public static void main(String[] args) {
		List<Snow> snow1 = Arrays.asList(new Crusty(),new Slush(),new Powder());
		
		// Won't compile:
//		List<Snow> snow2 = Arrays.asList(new Light(),new Heavy());
		// Compiler says:
	    // found   : java.util.List<Powder>
	    // required: java.util.List<Snow>
		
		// Collections.addAll() doesn't get confused:
		List<Snow> snow3 = new ArrayList<Snow>();
		Collections.addAll(snow3, new Light(),new Heavy());
		
		// Give a hint using an
	    // explicit type argument specification:
		List<Snow> snow4 = Arrays.<Snow>asList(new Light(),new Heavy());//显示类型参数说明。
		
		
	}

}
