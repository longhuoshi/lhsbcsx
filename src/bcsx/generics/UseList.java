package bcsx.generics;

import java.util.List;

/**
 * @author l
 * @date 2020/6/19 14:44
 * @description
 * 15.11.4 重载
 *
 * 下面的程序是不能编译的，即使编译它是一种合理的尝试
 *
 * 由于擦除的原因，重载方法将产生相同的类型签名。
 */
public class UseList<W,T> {
//    void f(List<T> v){}
    void f(List<W> v){}
}
