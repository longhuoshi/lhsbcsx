package bcsx.generics;

import bcsx.generics.coffee.Coffee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static bcsx.net.mindview.util.Print.print;

/**
 * @author l
 * @date 2020/8/11 17:16
 * @description
 *
 * 15.17.3 当你并未碰巧拥有正确的接口时
 */
public class Fill {
    public static <T> void fill(Collection<T> collection,Class<? extends T> classToken , int size){
        for (int i = 0; i < size; i++) {
            try {
                collection.add(classToken.newInstance());
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

    }
}

class Contract{
    private static long counter = 0;
    private final long id = counter++;
    public void rotate(){print(this + " rotate");}
    public String toString() {
        return getClass().getName() +" "+id;
    }
}

class TitleTransfer extends Contract{}

class FillTest{
    public static void main(String[] args) {
        List<Contract> contracts = new ArrayList<Contract>();
        Fill.fill(contracts,Contract.class,3);
        Fill.fill(contracts,TitleTransfer.class,2);
        for (Contract c:contracts)
            System.out.println(c);

        SimpleQueue<Contract> contractSimpleQueue = new SimpleQueue<>();
        // Won't work. fill() is not generic enough:
//         Fill.fill(contractSimpleQueue, Contract.class, 3);

    }
}


