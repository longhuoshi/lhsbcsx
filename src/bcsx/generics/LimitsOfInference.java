package bcsx.generics;

import java.util.*;

import bcsx.net.mindview.util.New;
import bcsx.typeinfo.pets.*;

public class LimitsOfInference {
	static void f(Map<Person,List<? extends Pet>> petPeople){}
	
	public static void main(String[] args) {
//		f(New.map());
		//��ʽ������˵��
		f(New.<Person,List<? extends Pet>>map());
		
	}

}
