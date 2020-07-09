package bcsx.generics;

/**
 * @author l
 * @date 2020/7/2 17:16
 * @description
 * 15.12.2 自限定
 *
 * 自限定所做的，就是要求在继承关系中，像下面这样使用这个类。
 * class A extends SelfBounded<A> {}
 * 这会强制要求将正在定义的类当作参数传递给基类。
 *
 */
class SelfBounded<T extends SelfBounded<T>>{
    T element;
    SelfBounded<T> set(T arg){
        element = arg;
        return this;
    }

    T get(){ return element; }

}

class A extends SelfBounded<A> {}
class B extends SelfBounded<A> {} // Also OK

class C extends SelfBounded<C> {
    C setAndGet(C arg){
        set(arg);
        return get();
    }
}

class D{}
//Can't do this:
//class E extends SelfBounded<D>{ }
//compile error :Type parameter D is not within its bound

class F extends SelfBounded{}


public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();
        C c = new C();
        c = c.setAndGet(new C());


    }
}
