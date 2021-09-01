package main.java.bcsx.exceptions;
/**
 * ����֪ͨ��������÷��ڹ��������׳��κ��쳣ʱҲӦ�����ã�����������ǣ��ڴ�����Ҫ����Ķ���֮��
��������һ��try-finally���飺
code CleanupIdiom.java
��main()�У�Section 1�൱�򵥣���ѭ���ڿ�ȥ������֮�����try-finally��ԭ����������첻��ʧ�ܣ���
����Ҫ�κ�catch����Section 2�У�Ϊ�˹�����������Կ������в���ʧ�ܵĹ������Ķ������Ⱥ����һ��
	Section 3չʾ����δ�����Щ���п���ʧ�ܵĹ�����������Ҫ����Ķ���Ϊ����ȷ������������������
�úܼ��֣���Ϊ����ÿһ������������������������Լ���try-finally�����У�����ÿһ����������붼
׷��һ��try-finally������ȷ������
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
