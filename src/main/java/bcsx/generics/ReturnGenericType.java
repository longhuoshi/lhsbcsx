package bcsx.generics;

/**
 * @author l
 * @date 2021/6/4 11:23
 * @description
 */
public class ReturnGenericType<T extends HasF> {
    private T obj;
    public ReturnGenericType(T x){
        obj = x;
    }
    public T get(){
        return obj;
    }
}
