package bcsx.generics;

/**
 * @author l
 * @date 2020/6/18 15:20
 * @description
 *
 * previous {@link MultipleinterfaceVariants}
 * next {@link NeedCasting }
 *
 * 15.11.3 转型和警告
 *  使用带有泛型类型参数的
 *
 */
class FixedSizeStack<T>{
    private int index = 0;
    private Object[] storage ;
    public FixedSizeStack(int size){
        storage = new Object[size];
    }
    public void push(T obj){
        storage[index++] = obj;
    }
    @SuppressWarnings("unchecked")
    public T pop(){
        return  (T)storage[--index];
    }
}
public class GenericCast {

    public static final int SIZE = 10 ;
    public static void main(String[] args) {
        FixedSizeStack<String> strings = new FixedSizeStack<>(SIZE);
        for(String s : "A B C D E F G H I J".split(" "))
            strings.push(s);

        for (int i = 0; i < SIZE; i++) {
            System.out.print(strings.pop()+" ");//如果去掉pop()的@SuppressWarnings，编译器将产生“unchecked”警告
        }

    }
}
