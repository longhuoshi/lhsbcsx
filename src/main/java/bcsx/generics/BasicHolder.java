package bcsx.generics;

/**
 * @author l
 * @date 2020/7/2 14:45
 * @description
 * 15.12.1 古怪的循环泛型
 * previous {@link CuriouslyRecurringGeneric}
 * next {@link CRGWithBasicHolder }
 */
public class BasicHolder<T> {
    T element;
    void set(T arg){element  = arg;}
    T get(){return element;}
    void f(){
        System.out.println(element.getClass().getSimpleName());
    }

}
