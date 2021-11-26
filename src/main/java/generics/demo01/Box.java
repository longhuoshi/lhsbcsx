package generics.demo01;

/**
 * @author l
 * @date 2021/11/25 10:14
 * @description
 */
public class Box<E> {
    private E first;

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }
}
