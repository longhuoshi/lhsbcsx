package bcsx.exceptions;

/**
 * 12.9 异常的限制。
当覆盖方法的时候，只能抛出在基类方法的异常说明里列出的那些异常。这个限制很有用，
因为这意味着，当基类使用的代码应用到其派生类对象的时候，一样能够工作（当然，这是
面向对象的基本概念），异常也不例外。
code StormyInning.java
在Inning类中，可以看到构造器和event()方法都声明将抛出异常，但实际上没有抛出。这种方式
使你能强制用户去捕获可能在覆盖后的event()版本中增加的异常，所以它很合理。这对于抽象
方法同样成立，比如atBat();
	接口Storm值得注意，因为它包含了一个在Inning中定义的方法event()和一个不在Inning中定义
的方法rainHard()。这两个方法都抛出新的异常RainedOut。如果StormyInning类在扩展Inning类的
同时又实现了Storm接口，那么Storm里的event方法就不能改变在Inning中的event()方法的异常接口。
否则的话，在使用基类的时候就不能判断是否捕获了正确的异常，所以这也很合理。当然，如果接口
里定义的方法不是来自于基类，比如rainHard()，那么此方法抛出什么样的异常都没有问题。
	异常限制对构造器不起作用，可以抛出基类以外的异常。但派生类构造器的异常说明必须包含基类
构造器的异常说明。
	StormyInning.walk()不能通过编译的原因是因为：它抛出了异常，而Inning.walk()并没有声明此
异常。如果编译允许这么做的话，就可以在调用Inning.walk()的时候不用做异常处理了，而且当把它
替换成Inning的派生类的对象时，这个方法有可能会抛出异常，于是程序就失灵了。通过强制派生类
遵守基类方法的异常说明，对象的可替换性得到了保证。
	覆盖后的event()方法表明，派生类方法可以不抛出任何异常，即使它是基类所定义的异常。同样这是
因为，假使基类的方法会抛出异常，这样做也不会破坏已有的程序，所以也没有问题。类似的情况出现
在atBat身上，它抛出的是PopFoul,这个异常继承自“会被基类的atBat()抛出”的Foul。这样，如果你写的
代码是同Inning打交道，并且调用了它的atBat()的话，那么肯定能捕获Foul。而PopFoul是由Foul派生
出来的，因此异常处理程序也能捕获PopFoul。
	尽管在继承过程中，编译器会对异常说明做强制要求，但异常说明本身并不属于方法类型的一部分，
方法类型是由方法的名字与参数的类型组成的。因此，不能基于异常说明来重载方法。此外，一个出现
在基类方法的异常说明中的异常，不一定会出现在派生类方法的异常说明里。这点同继承的规则明显不同，
在继承中，基类的方法必须出现在派生类里，换句话说，在继承和覆盖的过程中，某个特定方法的“异常
说明的接口”不是变大了而是变小了————这恰好 和类接口在继承时情形相反。
 * */
class BaseballException extends Exception{}
class Foul extends BaseballException{}
class Strike extends BaseballException{}

abstract class Inning {
	public Inning() throws BaseballException{}
	public void event () throws BaseballException{}
	public abstract void atBat() throws Strike,Foul;
	public void walk(){}
}

class StormException extends Exception{}
class RainedOut extends StormException{}

class PopFoul extends Foul{}

interface Storm{
	public void event() throws RainedOut;
	public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm{
	
	public StormyInning () throws RainedOut,BaseballException{
		
	}
	public StormyInning (String s) throws Foul,BaseballException{}
	//Regular methods must conform to base class:
//	public void walk() throws PopFoul {}
	
	//Interface CANNOT add exceptions to existing  methods from the base class:
//	public void event()throws RainedOut{}
	
	//If the method doesn't already exist in the base class, the exception is OK:
	public void rainHard() throws RainedOut{}
	//You can choose to not throw any exceptions, even if the base version does:
	public void event(){}
	
	// Overridden methods can throw inherited exceptions:
	public void atBat() throws PopFoul {}
	
	public static void main(String[] args)  {
		
		try {
			StormyInning si = new StormyInning();
			si.atBat();
		}catch(PopFoul e){
			System.out.println("Pop foul");
		}catch (RainedOut e1) {
			System.out.println("Rained out");
		} catch (BaseballException e1) {
			System.out.println("Generic baseball exception");
		}
	
		// Strike not thrown in derived version.
		try {
			//What happens if you upcast?
			Inning i = new StormyInning();
			i.atBat();
			
			Storm s = new StormyInning();
			s.event();
			//You must catch the exceptions from the base-class version of the method:
		}catch (Strike e) {
			System.out.println("Strike");
		} catch (Foul e) {
			System.out.println("Foul");
		} catch (RainedOut e) {
			System.out.println("Rained out");
		} catch (BaseballException e) {
			System.out.println("Generic baseball exception");
		}
	}
}
