package bcsx.strings;
/**
 * ������ ���޵�String�࣬���Ǹ�Ը�⹹��ǿ�� �ı��ʽ����
 * ��static Pattern.compile()�������������������ʽ���ɡ�
 * ����������String���͵�������ʽ����һ��Pattern����
 * ��������������Ҫ�������ַ�������Pattern���� ��matcher()������
 * matcher()����������һ��Matcher�������кܶ๦�ܿ��á�
 * 
 * ��������������������������������ʽ�����������ܷ�ƥ��һ������ �ַ�����
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
