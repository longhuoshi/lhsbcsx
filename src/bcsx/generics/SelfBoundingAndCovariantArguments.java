package bcsx.generics;

/**
 * @author l
 * @date 2020/7/7 9:53
 * @description
 *
 * 15.12.3 参数协变
 *
 * 在使用自限定类时，在导出类中只有一个方法。并且这个方法接受导出类型
 * 而不是基类型为参数 。
 */

interface SelfBoundSetter<T extends SelfBoundSetter<T>>{
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter>{ }

public class SelfBoundingAndCovariantArguments {
    void testA(Setter s1,Setter s2,SelfBoundSetter sbs){
        s1.set(s2);
//        s1.set(sbs);
        //Error: 'set(Setter)' in 'SelfBoundSetter<Setter>' cannot be applied to '(SelfBoundSetter)'

    }

}
