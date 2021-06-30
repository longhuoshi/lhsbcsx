package bcsx.generics;

/**
 * @author l
 * @date 2020/7/6 15:08
 * @description
 * 15.12.2 自限定
 * previous {@link NotSelfBounded}
 * next {@link CovariantReturnTypes }
 *
 */
public class SelfBoundingMethods {
    static <T extends SelfBounded<T>> T f(T arg){
        return arg.set(arg).get();
    }

    public static void main(String[] args) {
        A a = f(new A());

    }

}
