package main.java.bcsx.holding;

import java.util.Map;
/**
 * ��java se5�У��������඼��Iterable���ͣ���Ҫ�������е�Collection�ࣨ���ǲ���������Map����
���磺����Ĵ��������ʾ���еĲ���ϵͳ����������
code
System.getenv()����һ��Map, .entrySet����һ����Map.Entry��Ԫ�ع��ɵ�Set���������Set��һ��Ierable��
�������������foreachѭ����
 * */
public class EnvironmentVariables {

	public static void main(String[] args) {
		for(Map.Entry entry : System.getenv().entrySet()){
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}

}
