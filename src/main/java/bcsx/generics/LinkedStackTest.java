package bcsx.generics;

public class LinkedStackTest {

	public static void main(String[] args) {
		LinkedStack<String> lks = new LinkedStack<String>();
		for(String str:"Phasers on stun!".split(" "))
			lks.push(str);
		
		String aa = null;
		while(( aa = lks.pop()) !=null){
			System.out.println(aa);
		}

	}

}
