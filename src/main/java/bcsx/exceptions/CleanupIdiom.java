package bcsx.exceptions;
/**
 * 这种通知的清理惯用法在构造器不抛出任何异常时也应该运用，其基本规则是：在创建需要清理的对象之后，
立即进入一个try-finally语句块：
code CleanupIdiom.java
在main()中，Section 1相当简单：遵循了在可去除对象之后紧跟try-finally的原则。如果对象构造不能失败，就
不需要任何catch。在Section 2中，为了构造和清理，可以看到具有不能失败的构造器的对象可以群组在一起。
	Section 3展示了如何处理那些具有可以失败的构造器，且需要清理的对象。为了正确处理这种情况，事情变
得很棘手，因为对于每一个构造器，都必须包括在其自己的try-finally语句块中，并且每一个对象构造必须都
追随一个try-finally语句块以确保清理。
 * */
//Each disposable object must be followed by a try-finally
class NeedsCleanup{//Construction can't fail
	private static long counter = 1;
	private final long id = counter++;
	public void dispose(){
		System.out.println("NeedsCleanup " + id + " disposed");
	}
}

class ConstructionException extends Exception{}

class NeedsCleanup2 extends NeedsCleanup{
	// Construction can fail:
	public NeedsCleanup2() throws ConstructionException{}
}

public class CleanupIdiom {
	public static void main(String[] args) {
		//Section 1:
		NeedsCleanup nc = new NeedsCleanup();
		try{}finally{
			nc.dispose();
		}
		
		//Section 2:
		// If construction cannot fail you can group objects:
		NeedsCleanup nc2 = new NeedsCleanup();
		NeedsCleanup nc3 = new NeedsCleanup();
		try{}finally{
			nc3.dispose();
			nc2.dispose();
		}
		
		//Section 3:
		//If construction can fail you must guard each one:
		try{
			NeedsCleanup2 nc4 = new NeedsCleanup2();
			try{
				NeedsCleanup2 nc5 = new NeedsCleanup2();
				try{}finally{
					nc5.dispose();
				}
			}catch(ConstructionException e){// nc5 constructor
				System.out.println(e);
			}finally{
				nc4.dispose();
			}
		}catch(ConstructionException e){//nc4 constructor
			System.out.println(e);
		}
	}
}
