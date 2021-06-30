package bcsx.containers;

import java.util.*;

import static bcsx.net.mindview.util.Print.*;

/**
 * @author l
 * @date 2020/9/25 17:28
 * @description
 * 17.6.1 SortedSet
 * 注意，SortedSet的意思 是“按对象的比较函数对元素排序 ”，而不是
 * 指“元素插入的次序”。插入顺序可以用LinkedHashSet来保存。
 *
 *
 */
public class SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();
        Collections.addAll(sortedSet,"one two three four five six seven eight".split( " "));
        print(sortedSet);
        String low = sortedSet.first();
        String high = sortedSet.last();
        print(low);
        print(high);
        Iterator<String> it = sortedSet.iterator();
        for (int i = 0; i <=6 ; i++) {
            if(i == 3) low = it.next();
            if(i == 6) high = it.next();
            else it.next();
        }

        print(low);
        print(high);
        print(sortedSet.subSet(low, high));
        print(sortedSet.headSet(high));
        print(sortedSet.tailSet(low));

    }
}
