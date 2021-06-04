package bcsx.generics;


/**
 * p 412
 *在泛型中的所有动作都发生在边界处————对传递进来的值进行额外的编译期检查，
 * 并插入对传递出去的值的转换。这有肋于澄清对擦除的混淆，
 * 记住“边界就是发生动作的地方。”
 *
 *(可见：泛型中所有动作都是发生在边界处—–对传进来的值进行额外编译期检查，
 * 并插入对传递出去的值的转型。这里的边界就是指的发生 “传进来”(set)、 “传出去“”(get)动作的地方。)
 * */
public class GenericHolder<T> {
	private T obj;
	public void set(T t){this.obj = obj;}
	public T get(){return obj;}
	
	public static void main(String[] args) {
		GenericHolder<String> holder = new GenericHolder<String>();
		holder.set("Item");
		String s = holder.get();
	}

}
