package bcsx.exceptions;
/**
 * 12.11异常匹配
	抛出异常的时候，异常处理系统会按照代码的书写顺序找出“最近”的处理程序。找到匹配的处理程序之后，
它就认为异常将得到处理，然后就不再继续查找。
	查找的时候并不要求抛出的异常同处理程序所声明的异常完全匹配。派生类的对象也可以匹配其基类的处理
程序，就像这样：
code Human.java
	catch(Annoyance e)会捕获Annoyance以及所有从它派生的异常。这一点非常有用，因为如果决定在方法里加上
更多派生异常的话，只要客户程序员捕获的是基类异常，那么它们的代码就无需更改。
 * */
class Annoyance extends Exception{}
class Sneeze extends Annoyance{}

public class Human {
	public static void main(String[] args) {
		// Catch the exact type:
		try {
			throw new Sneeze();
		} catch (Sneeze e) {
			System.out.println("Caught Sneeze");
		}catch(Annoyance e){
			System.out.println("Caught Annoyance");
		}
		
		// Catch the base type:
		try {
			throw new Sneeze();
		} catch (Annoyance e) {
			System.out.println("Caught Annoyance");
		}
	}
}
