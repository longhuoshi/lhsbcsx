package bcsx.innerclasses;

/**
 * ��ӵ���ⲿ��֮ǰ���ǲ����� �����ڲ������ģ�������Ϊ�ڲ������ᰵ�����ӵ����������ⲿ������ϡ�
 * */
public class DotNew {
	public class Inner{};
	public static void main(String[] args){
		DotNew dotNew = new DotNew();
		DotNew.Inner dni = dotNew.new Inner();
		
		
		
	}
}
