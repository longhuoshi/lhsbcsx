package main.java.bcsx.typeinfo;
/**
 * 14.2.3 �µ�ת���﷨
 * */
class Building{}
class House extends Building{}

public class ClassCasts {

	public static void main(String[] args) {
		Building b = new House();
		Class<House> houseType = House.class;
		House h = houseType.cast(b);
		h = (House)b;
		
		if(b instanceof House){
			System.out.println("b����House��");
		}else{
			System.out.println("b������House��");
		}
		
		
	}

}
