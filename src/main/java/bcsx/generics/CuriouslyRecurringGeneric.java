package bcsx.generics;

/**
 * @author l
 * @date 2020/7/2 14:40
 * @description
 * 15.12.1 古怪的循环泛型。
 * previous {@link Hamster}
 * next {@link BasicHolder }
 * 为了理解其含义，努力大声说：我在创建一个新类，它继承自一个泛型类型，
 * 这个泛型类型接受 我的类的名字作为其参数 。
 * Java的泛型关乎参数和导出类型，因此它能够产出使用导出类作为其参数
 * 和返回类型的基类。
 *
 */
class GenericType<T>{}

public class CuriouslyRecurringGeneric  extends GenericType<CuriouslyRecurringGeneric>{

}
