package main.java.bcsx.strings;

import java.util.ArrayList;
import java.util.List;
/**
 * �����ϣ��toString()������ӡ��������ڴ��ַ��Ҳ����ῼ����this�ؼ��֡�
code InfiniteRecursion.java
���㴴����InfiniteRecursion���󣬲������ӡ������ʱ�����õ�һ���ǳ������쳣��
������InfiniteRecursion����浽List�У�Ȼ���ӡList��������õ�ͬ�����쳣����ʵ��
�����´�������ʱ��
" InfiniteRecursion address: " + this
	���﷢�����Զ�����ת������InfiniteRecursion����ת����String���ͣ�����ôת���أ�����
ͨ������this�ϵ�toString���������Ƿ����˵ݹ���á�
	����������Ҫ��ӡ��������ڴ��ַ��Ӧ�õ���Object.toString()����������Ǹ��������ķ�����
�����㲻Ӧ����this,����Ӧ�õ���super.toString()������
 * */
public class InfiniteRecursion {
	
	public String toString(){
		//�ݹ���á�(thisת���ַ���������toString()������)
		return " InfiniteRecursion address: " + this + "\n";
//		return " InfiniteRecursion address: " + super.toString() + "\n";
	}
	
	public static void main(String[] args) {
		List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
		for(int i=0;i<10;i++)
			v.add(new InfiniteRecursion());
		System.out.println(v);
	}

}
