package bcsx.generics;

import java.util.List;

/**
 * @author l
 * @date 2020/6/19 14:44
 * @description
 * 15.11.4 重载
 * previous {@link UseList}
 * next {@link ComparablePet }
 * 当被擦除的参数不能产生唯一的参数列表时，必须提供明显有区别的方法名。
 */
public class UseList2<W,T> {
    void f1(List<T> v){}
    void f2(List<W> v){}
}
