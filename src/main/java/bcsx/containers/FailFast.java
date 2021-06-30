package bcsx.containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author l
 * @date 2021/2/22 11:02
 * @description
 * 快速报错
 */
public class FailFast {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
//        c.add("An object2");//正确的位置应该在这里
        Iterator<String> it = c.iterator();
        c.add("An object");  //在窗口取得迭代器之后，不能再往容器添加东西。否则报异常。应该在添加完所有的元素之后，再获取迭代器。
        try {
            String s = it.next();

        }catch (ConcurrentModificationException e){
            System.out.println(e);
        }

    }
}
/* Output:
java.util.ConcurrentModificationException
*///:~