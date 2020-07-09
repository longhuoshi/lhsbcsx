package bcsx.generics;

/**
 * @author l
 * @date 2020/7/6 15:32
 * @description
 *
 * 15.12.3 参数协变
 *
 */

class Base{}
class Derived extends Base{}
class DogBitch{}
interface OrdinaryGetter{
    Base get();
}

interface DerivedGetter extends OrdinaryGetter{
    // Return type of overridden method is allowed to vary:
    Derived get();
}

public class ConvariantReturnTypes {
    void test(DerivedGetter d){
        Derived d2 = d.get();
    }
}
