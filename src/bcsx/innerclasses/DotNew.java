package bcsx.innerclasses;

/**
 * 在拥有外部类之前你是不可能 创建内部类对象的，这是因为内部类对象会暗暗连接到创建它的外部类对象上。
 * */
public class DotNew {
	public class Inner{};
	public static void main(String[] args){
		DotNew dotNew = new DotNew();
		DotNew.Inner dni = dotNew.new Inner();
		
		
		
	}
}
