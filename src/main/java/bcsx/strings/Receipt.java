package bcsx.strings;
/**
 * 13.5.3 Formatter��13.5.4 ��ʽ��˵������
�ڲ�������ʱ�������Ҫ���ƿո�����룬����Ҫ����ϸ���ӵĸ�ʽ���η���
������������﷨��
%[argument_index$][flags][width][.precision]conversion
�����Ӧ���ǿ���һ�������С�ߴ磬�����ͨ��ָ��width��ʵ�֣�Formatter��������������
û�дﵽָ��width�����ո�ȷ��һ�������ٴﵽĳ�����ȡ���Ĭ��������������Ҷ���ģ�����
����ͨ��ʹ�á�-����־���ı���뷽��
	��width��Ե���precision��������ָ�����ߴ硣
width����Ӧ���ڸ������͵�����ת������������Ϊ��ʽ��һ����
precision�����������͵����ݶ���ʹ�á�����Ӧ���ڲ�ͬ���͵�����ת��ʱ��precision������Ҳ��ͬ��
1����precisionӦ����Stringʱ������ʾ��ӡStringʱ����ַ���������
2����precisionӦ���ڸ�����ʱ������ʾС������Ҫ��ʾ������λ����Ĭ����6λС���������С��λ��
���������룬̫������β�����㡣
��������û��С�����֣�����precision�޷�Ӧ�������������Ӧ�������� ���ᴥ���쳣��
(�Լ��ܽ᣺width�Ƕ����������ռλ�õĴ�С���ã�precision�Ƕ����ݱ����ȵ����ơ�)
����ĳ���Ӧ�ø�ʽ���η�����ӡһ�������վݣ�
code Receipt.java
 * */
import java.util.Formatter;

public class Receipt {
	private double total = 0;
	private Formatter f = new Formatter(System.out);
	public void printTitle(){
		f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
		f.format("%-15s %5s %10s\n", "----", "---", "-----");
	}
	public void print(String name, int qty, double price){
		f.format("%-15.15s %5d %10.2f\n", name,qty,price);
		total += price;
	}
	public void printTotal(){
		f.format("%-15s %5s %10.2f\n", "Tax", "", total*0.06);
		f.format("%-15s %5s %10s\n", "","","-----");
		f.format("%-15s %5s %10.2f\n", "Total", "",total * 1.06);
	}
	
	public static void main(String[] args) {
		Receipt r = new Receipt();
		r.printTitle();
		r.print("Jack's Magic Beans", 4, 4.25);
	    r.print("Princess Peas", 3, 5.1);
	    r.print("Three Bears Porridge", 1, 14.29);
	    r.printTotal();
	    
	    System.out.format("%05X", 32);
	}

}
