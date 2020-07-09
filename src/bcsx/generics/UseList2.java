package bcsx.generics;

import java.util.List;

/**
 * @author l
 * @date 2020/6/19 14:44
 * @description
 * 15.11.4 重载
 *
 */
public class UseList2<W,T> {
    void f1(List<T> v){}
    void f2(List<W> v){}
}
