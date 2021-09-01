package bcsx.generics;

/**
 * @author l
 * @date 2020/7/6 15:32
 * @description
 *
 * 15.12.3 参数协变
 * previous {@link SelfBoundingMethods}
 * next {@link GenericsAndReturnTypes }
 *
 * 自限定类型的价值在于它们可以产生 协变参数类型————方法参数类型会随子类而变化 。
 * 尽管自限定类型还可以产生于子类类型相同的返回类型，但是这并不十分重要， 因为
 * 协变返回类型 是JavaSE5中引入 的；
 */

class Base{}
class Derived extends Base{}

interface OrdinaryGetter{
    Base get();
}

interface DerivedGetter extends OrdinaryGetter{
    // Return type of overridden method is allowed to vary:
    Derived get();
}

public class CovariantReturnTypes {
    void test(DerivedGetter d){
        Derived d2 = d.get();
    }
}
