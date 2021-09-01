package bcsx.exceptions;
/**
 * 12.8.2 ��return��ʹ��finally.
��Ϊfinally�Ӿ����ǻ�ִ�еģ�������һ�������У����ԴӶ���㷵�أ����ҿ��Ա�֤��Ҫ
���������Ծɻ�ִ��:
code 
������п��Կ�������finally���ڲ����Ӻδ������޹ؽ�Ҫ��
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
