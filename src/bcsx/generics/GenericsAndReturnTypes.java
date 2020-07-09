package bcsx.generics;

/**
 * @author l
 * @date 2020/7/6 15:47
 * @description
 * 15.12.3 参数协变
 *
 * 自限定泛型事实 上将产生确切的导出类型作为其返回值。就像在get()中所看到一样:
 *
 * 注意这段代码不能编译，除非是使用囊括了协变返回类型的java SE5
 *
 */
interface GenericGetter<T extends GenericGetter<T>>{
    T get();
}

interface Getter extends GenericGetter<Getter>{}

public class GenericsAndReturnTypes {
    void  test(Getter g){
        Getter result = g.get();
        GenericGetter gg = g.get();//Also the base type

    }
}
