package bcsx.containers;

import bcsx.net.mindview.util.CollectionData;
import bcsx.net.mindview.util.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author l
 * @date 2020/9/21 10:40
 * @description
 *
 * 17.2.1 一种Generator解决方案。
 */

class Government implements Generator<String>{
    String[] foundation = ("strange women lying in ponds " +
            "distributing swords is no basis for a system of " +
            "government").split(" ");
    private int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}

public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(new CollectionData<String>(new Government(),15));
        // Using the convenience method:
        set.addAll(CollectionData.list(new Government(),15));
        System.out.println(set);

    }
}
