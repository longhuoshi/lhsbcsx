package bcsx.exceptions;
/**
 * 12.8.2 在return中使用finally.
因为finally子句总是会执行的，所以在一个方法中，可以从多个点返回，并且可以保证重要
的清理工作仍旧会执行:
code 
从输出中可以看出，在finally类内部，从何处返回无关紧要。
 * */
public class MultipleReturns {
	
	public static void f(int i){
		System.out.println("Initialization that requires cleanup");
		try{
			System.out.println("Point 1 ");
			if(i==1) return;
			System.out.println("Point 2 ");
			if(i==2) return;
			System.out.println("Point 3 ");
			if(i==3) return;
			System.out.println("End ");
			
		}finally{
			System.out.println("Performing cleanup");
			
		}
	}
	public static void main(String[] args) {
		for(int i=1; i<=4;i++)
			f(i);
	}
}
