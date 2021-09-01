package bcsx.generics;

/**
 * @author l
 * @date 2020/7/2 14:59
 * @description
 * CRG means “古怪的循环”
 * 15.12.1 古怪的循环泛型
 * previous {@link BasicHolder}
 * next {@link Unconstrained }
 *
 * CRG:古怪的循环泛型
 *
 * 注意，这里有些东西很重要：新类subtype接受的参数和返回的值具有Subtype类型而不仅
 * 仅是基类BasicHolder类型。这就是CRG的本质：基类用导出类替代其参数。  这意味着泛型类
 * 变成了一种其所有导出类的公共功能 的模版，但是这些功能对于其所有参数和返回值，将使用导出类型。
 * 也就是说，在所产生的类中将使用确切类型而不是基类型。
 *
 */
class Subtype extends BasicHolder<Subtype>{}
public class CRGWithBasicHolder {
    public static void main(String[] args) {
        Subtype st1 = new Subtype(),st2 = new Subtype();
        st1.set(st2);
        Subtype st3 = st1.get();
        st1.f();



    }
}
