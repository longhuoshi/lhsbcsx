package bcsx.typeinfo;
/**
 * 14.2.3 新的转型语法
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
			System.out.println("b属于House类");
		}else{
			System.out.println("b不属于House类");
		}
		
		
	}

}
