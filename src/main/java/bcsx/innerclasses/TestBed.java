package main.java.bcsx.innerclasses;
/**
 * ��Ƕ���������ò��Դ���
 * �ô��ǲ����ظ������Ѿ�������Ĵ��롣
 * ��������һ����������TestBed$Tester��(Ҫ�����������ִ��java TestBed$Tester���ɡ�)
 * ����ʹ��������������ԡ�
 * */
public class TestBed {
	public void f(){System.out.println("f()");}
	
	// Ƕ����
	public static class Tester{
		public static void main(String[] args){
			TestBed t = new TestBed();
			t.f();
		}
	}
}
