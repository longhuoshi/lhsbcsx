package bcsx.generics;

/**
 * @author l
 * @date 2020/7/7 16:39
 * @description
 *15.12.3 参数协变
 *
 * 如果不使用自限定，将重载参数类型。如果使用了自限定，只能
 * 获得某个方法的一个版本，它将接受确切的参数类型。
 */

class GenericSetter<T>{
    void set(T arg){
        System.out.println("GenericSetter.set(Base)");
    }
}

class DerivedGS extends GenericSetter<Base>{
    void set(Derived derived){
        System.out.println("DerivedGS.set(Derived)");
    }
}

public class PlainGenericInheritance {
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedGS dgs = new DerivedGS();
        dgs.set(derived);
        dgs.set(base); //compiles:overloaded ,not overridden!


    }
}
