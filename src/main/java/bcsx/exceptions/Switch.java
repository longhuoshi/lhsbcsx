package main.java.bcsx.exceptions;


/**
 * 12.8ʹ��finally����
	����һЩ���룬���ܻ�ϣ������try���е��쳣�Ƿ��׳������Ƕ��ܵõ�ִ�С���ͨ������
����Ա�����ͷ��ڴ�������Ϊ�˴ﵽ���Ч�����������쳣�������������finally�Ӿ䡣
�������쳣�������������������
try{
}catch(A a){
}catch(B b){
}finally{
}
Ϊ��֤��finally�Ӿ��������У��������������������

12.8.1finally������ʲô
	����û���������պ����������Զ����û��Ƶ�������˵��finally�ǳ���Ҫ������ʹ����Ա��֤��
����try���﷢����ʲô���ڴ����ܵõ��ͷš���java���������ջ��ƣ������ڴ��ͷŲ��������⡣
���ң�javaҲû�����������ɹ����á���ô��java��ʲô����²����õ�finally�أ�
	��Ҫ�ѳ��ڴ�֮�����Դ�ָ������ǵĳ�ʼ״̬ʱ����Ҫ�õ�finally�Ӿ䡣������Ҫ�������Դ
�������Ѿ��򿪵��ļ����������ӣ�����Ļ�ϻ���ͼ�Σ������������ⲿ�����ĳ�����أ�������
������ʾ��
code Switch.java OnOffException1.java OnOffException2.java,OnOffSwitch.java
�����Ŀ����ȷ��main()������ʱ�򿪹ر����ǹرյģ�������ÿ��try����쳣��������ĩβ��
�����˶�sw.off()�����ĵ��� ��
 * */
public class Switch {
	private boolean state = false;
	public boolean read(){return state;}
	public void on(){
		state = true;
		System.out.println(this);
	}
	public void off(){
		state = false;
		System.out.println(this);
	}
	public String toString(){
		return state ? "on" : "off";
	}

}
