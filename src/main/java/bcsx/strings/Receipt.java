package bcsx.strings;
/**
 * 13.5.3 Formatter类13.5.4 格式化说明符。
在插入数据时，如果想要控制空格与对齐，你需要更精细复杂的格式修饰符，
以下是其抽象语法：
%[argument_index$][flags][width][.precision]conversion
最常见的应用是控制一个域的最小尺寸，这可以通过指定width来实现，Formatter对象会在输出内容
没有达到指定width来补空格，确保一个域至少达到某个长度。在默认情况下数据是右对齐的，不过
可能通过使用“-”标志来改变对齐方向。
	与width相对的是precision，它用来指明最大尺寸。
width可以应用于各种类型的数据转换，并且其行为方式都一样。
precision不是所有类型的数据都能使用。而且应该于不同类型的数据转换时，precision的意义也不同。
1）将precision应用于String时，它表示打印String时输出字符串最大个数
2）将precision应用于浮点数时，它表示小数部分要显示出来的位数（默认是6位小数），如果小数位数
过多则舍入，太少则在尾部补零。
由于整数没有小数部分，所以precision无法应用于整数。如果应用于整数 ，会触发异常。
(自己总结：width是对输出数据所占位置的大小设置，precision是对数据本身长度的限制。)
下面的程序应用格式修饰符来打印一个购物收据：
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
