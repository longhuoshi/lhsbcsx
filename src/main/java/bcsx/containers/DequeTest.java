package bcsx.containers;

import bcsx.net.mindview.util.Deque;
import static bcsx.net.mindview.util.Print.*;

/**
 * @author l
 * @date 2020/9/27 15:40
 * @description
 * 17.7.2 双向队例
 */
public class DequeTest {
    static void fillTest(Deque<Integer> deque){
        for (int i = 20; i < 27; i++) {
            deque.addFirst(i);
        }
        for (int i = 50; i < 55; i++) {
            deque.addLast(i);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> di = new Deque<>();
        fillTest(di);
        print(di);
        while(di.size() != 0)
            printnb(di.removeFirst() + " ");
        print();
        fillTest(di);
        while(di.size() != 0)
            printnb(di.removeLast() + " ");

    }
}
