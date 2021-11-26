package generics.demo01;

/**
 * @author l
 * @date 2021/11/25 14:26
 * @description
 */
public class Erasure<T> {
    public T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}
