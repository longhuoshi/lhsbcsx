package bcsx.generics;
//下一页SuperTypeWildcards  上一页CompilerIntelligence
/**
 * 配符上限和通配符下限的简单解释
 * <? extends T>上限通配，表示？是T的一个未知子类。
 * <? super T>下限通配，表示？是T的一个未知父类。
 * */
public class Holder<T> {
	private T value;
	public Holder(){}
	public Holder(T val){
		this.value = val;
	}
	public void set(T t ){
		this.value = t;
	}
	public T get(){
		return value;
	}
	
	public boolean equals(Object obj){
		return value.equals(obj);
	}
	
	
	public static void main(String[] args) {	
		Holder<Apple> apple = new Holder<Apple>(new Apple());
		Apple d = apple.get();
		apple.set(d);
//		Holder<Fruit> fruit = apple;  //Cannot upcast
		//Holder<? extends Fruit> 这个边界是“任何扩展自Fruit的对象”
		Holder<? extends Fruit> fruit = apple;

		Fruit f = fruit.get();
		d = (Apple) fruit.get();
		try{
			Orange o = (Orange) fruit.get();
		}catch(Exception e){
			System.out.println(e);
		}

//		fruit.set(new Apple()); //Cannot call set()
		System.out.println(fruit.equals(d));
		
	}

}
