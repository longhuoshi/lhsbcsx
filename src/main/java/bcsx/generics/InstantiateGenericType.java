package main.java.bcsx.generics;
/*
 * 没有编译期检查的泛型。。
 * 
 * 这个可以编译，但会因为ClassAsFactory<Integer>而失败。
 * 因为Integer没有任何默认的构造器。因为这个错误不是在编译期捕获的。
 * 所以sun的伙计们对这种方式 并不赞成
 * */
class ClassAsFactory<T>{
	T x;
	public ClassAsFactory(Class<T> kind){
		try {
			x = kind.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
}

class Employee{}

public class InstantiateGenericType {

	public static void main(String[] args) {
		ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);
		System.out.println("ClassAsFactory<Employee> succeeded   "+fe.x);
		try{
			ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class); 
			
		}catch(Exception e){
			System.out.println("ClassAsFactory<Integer> failed");
			
		}
		
	}

}
