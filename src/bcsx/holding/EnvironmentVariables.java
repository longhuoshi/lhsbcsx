package bcsx.holding;

import java.util.Map;
/**
 * 在java se5中，大量的类都是Iterable类型，主要包括所有的Collection类（但是不包括各种Map）。
例如：下面的代码可以显示所有的操作系统环境变量。
code
System.getenv()返回一个Map, .entrySet产生一个由Map.Entry的元素构成的Set，并且这个Set是一个Ierable，
因此它可以用于foreach循环。
 * */
public class EnvironmentVariables {

	public static void main(String[] args) {
		for(Map.Entry entry : System.getenv().entrySet()){
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}

}
