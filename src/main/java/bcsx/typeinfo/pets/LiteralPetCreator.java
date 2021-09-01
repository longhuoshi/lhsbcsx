//: typeinfo/pets/LiteralPetCreator.java
// Using class literals.
package  main.java.bcsx.typeinfo.pets;
import java.util.*;
/**
 * 14.3.1 ʹ�������泣����
 * */
public class LiteralPetCreator extends PetCreator {
  // No try block needed.
  @SuppressWarnings("unchecked")
  public static final List<Class<? extends Pet>> allTypes =
    Collections.unmodifiableList(Arrays.asList(
      Pet.class, Dog.class, Cat.class,  Rodent.class,
      Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
      Cymric.class, Rat.class, Mouse.class,Hamster.class));
  // Types for random creation:
  private static final List<Class<? extends Pet>> types =
    allTypes.subList(allTypes.indexOf(Mutt.class),
      allTypes.size());
  public List<Class<? extends Pet>> types() {
    return types;
  }	
  public static void main(String[] args) {
    System.out.println(types);
  }
} /* Output:
[class  main.java.bcsx.typeinfo.pets.Mutt, class  main.java.bcsx.typeinfo.pets.Pug, class  main.java.bcsx.typeinfo.pets.EgyptianMau, class  main.java.bcsx.typeinfo.pets.Manx, class  main.java.bcsx.typeinfo.pets.Cymric, class  main.java.bcsx.typeinfo.pets.Rat, class  main.java.bcsx.typeinfo.pets.Mouse, class  main.java.bcsx.typeinfo.pets.Hamster]
*///:~
