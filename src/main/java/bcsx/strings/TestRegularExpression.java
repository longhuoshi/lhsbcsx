package bcsx.strings;
/**
 * 比起功能 有限的String类，我们更愿意构造强大 的表达式对象。
 * 用static Pattern.compile()方法来编译你的正则表达式即可。
 * 它会根据你的String类型的正则表达式生成一个Pattern对象。
 * 接下来，把你想要检索的字符串传入Pattern对象 的matcher()方法。
 * matcher()方法会生成一个Matcher对象，它有很多功能可用。
 * 
 * 下面的类可以用来可以用来测试正则表达式，看看它们能否匹配一个输入 字符串。
 * */
import java.util.regex.*;

public class TestRegularExpression {

	public static void main(String[] args) {
		if(args.length<2){
//			System.out.println("Usage:\njava TestRegularExpression characterSequence regularExpression+");
//			System.exit(0);
			args = new String[]{"abcabcabcdefabc","abc+","(abc)+","(abc){1,}"};
		}
		
		System.out.println("Input: \"" + args[0] + "\"");
		for(String arg : args){
			System.out.println("Regular expression: \"" + arg + "\"");
			
			Pattern p = Pattern.compile(arg);
			Matcher m = p.matcher(args[0]);
			while(m.find()){
				System.out.println("Match \""+m.group()+"\" at positions "+ m.start() +"-"+(m.end()-1));
				
			}
		}
	}

}
