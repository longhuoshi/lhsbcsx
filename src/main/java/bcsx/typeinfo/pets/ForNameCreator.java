//: typeinfo/pets/ForNameCreator.java
package  main.java.bcsx.typeinfo.pets;
import java.util.*;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types =
    new ArrayList<Class<? extends Pet>>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "main.java.bcsx.typeinfo.pets.Mutt",
    "main.java.bcsx.typeinfo.pets.Pug",
    "main.java.bcsx.typeinfo.pets.EgyptianMau",
    "main.java.bcsx.typeinfo.pets.Manx",
    "main.java.bcsx.typeinfo.pets.Cymric",
    "main.java.bcsx.typeinfo.pets.Rat",
    "main.java.bcsx.typeinfo.pets.Mouse",
    "main.java.bcsx.typeinfo.pets.Hamster"
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
