package bcsx.generics;

/**
 * 15.8.2 泛型数组
 * 编译器 接受这个程序 ，而不会产生任何警告。但是，永远 不能创建这个确切类型的数组（包括类型参数。）
 *
 * */

class Generic<T>{}

public class ArrayOfGenericReference {
	static Generic<Integer>[] gia;
}
