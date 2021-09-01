package main.java.bcsx.typeinfo;

import java.util.LinkedHashMap;
import java.util.Map;

import main.java.bcsx.net.mindview.util.MapData;
import main.java.bcsx.typeinfo.pets.LiteralPetCreator;
import main.java.bcsx.typeinfo.pets.Pet;
import main.java.bcsx.typeinfo.pets.Pets;

/**
 * 14.3.2 ��̬��instanceof��
 *  Using isInstance()
 * */
public class PetCount3 {
	static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer>{
		public PetCounter(){
			super(MapData.map(LiteralPetCreator.allTypes, 0));
		}
		
		public void count(Pet pet){
			//Class.isInstance() eliminates instanceofs:
			for(Map.Entry<Class<? extends Pet> , Integer> pair : entrySet()){
				if(pair.getKey().isInstance(pet)){
					put(pair.getKey(),pair.getValue()+1);
				}
			}
		}
		
		public String toString(){
			StringBuilder result = new StringBuilder("{");
			for(Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()){
				result.append(pair.getKey().getSimpleName());
				result.append("=");
				result.append(pair.getValue());
				result.append(",");
			}
			result.delete(result.length()-1, result.length());
			result.append("}");
			
			return result.toString();
		}
		
	}
	
	public static void main(String[] args) {
		PetCounter petCount = new PetCounter();
		for(Pet pet : Pets.createArray(20)){
			System.out.print(pet.getClass().getSimpleName()+" ");
			petCount.count(pet);
		}
		System.out.println();
		System.out.println(petCount);
		
	}
	
	/**�����ù��ġ�*/
	public static void test(Iterable<Class<? extends Pet>> genK, Integer value){
		for(Class<? extends Pet> key : genK) {
		      System.out.println(key);
		    }
	}

}
