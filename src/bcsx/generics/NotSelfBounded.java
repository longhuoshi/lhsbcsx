package bcsx.generics;

/**
 * @author l
 * @date 2020/7/6 14:44
 * @description
 */
public class NotSelfBounded<T> {
    T element;
    NotSelfBounded<T> set(T arg){
        element = arg;
        return this;
    }

    T get(){return  element; }

}

class A2 extends NotSelfBounded<A2>{}
class B2 extends NotSelfBounded<A2>{}
class C2 extends NotSelfBounded<C2>{
    C2 setAndGet(C2 arg){
        set(arg);
        return get();
    }
}

class D2{}
//Now this is ok
class E2 extends NotSelfBounded<D2>{}
