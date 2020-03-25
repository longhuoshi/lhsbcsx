//: typeinfo/pets/ForNameCreator.java
package  bcsx.typeinfo.pets;
import java.util.*;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types =
    new ArrayList<Class<? extends Pet>>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "bcsx.typeinfo.pets.Mutt",
    "bcsx.typeinfo.pets.Pug",
    "bcsx.typeinfo.pets.EgyptianMau",
    "bcsx.typeinfo.pets.Manx",
    "bcsx.typeinfo.pets.Cymric",
    "bcsx.typeinfo.pets.Rat",
    "bcsx.typeinfo.pets.Mouse",
    "bcsx.typeinfo.pets.Hamster"
  };	
  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames)
        types.add((Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static { loader(); }
  public List<Class<? extends Pet>> types() {return types;}
} ///:~
