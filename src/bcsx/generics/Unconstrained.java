package bcsx.generics;

/**
 * @author l
 * @date 2020/7/2 15:25
 * @description
 * 15.12.2 自限定
 *
 */
class Other{}
class BasicOther extends BasicHolder<Other>{}
public class Unconstrained {
    public static void main(String[] args) {
        BasicOther b = new BasicOther(), b2 = new BasicOther();
        b.set(new Other());
        Other other = b.get();
        b.f();

    }
}
