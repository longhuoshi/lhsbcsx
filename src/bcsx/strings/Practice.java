package bcsx.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice {

	public static void main(String[] args) {
		String str = "Java now has regular expressions";
		String[] regex = new String[]{"^Java","\\Breg.*","n.w\\s+h(a|i)s","s?","s*","s+","s{4}","s{0,3}"};
		System.out.println("str£º"+str);
		for(String r:regex){
			System.out.println("regular expression£º"+r);
			Pattern pattern = Pattern.compile(r);
			Matcher m = pattern.matcher(str);
			while(m.find()){
				System.out.println(m.group());
			}
			
			
		}
	}

}
