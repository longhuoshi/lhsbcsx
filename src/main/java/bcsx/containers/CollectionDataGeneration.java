package bcsx.containers;

import bcsx.net.mindview.util.CollectionData;
import bcsx.net.mindview.util.Pair;
import bcsx.net.mindview.util.RandomGenerator;
import bcsx.strings.ArrayListDisplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author l
 * @date 2020/9/21 11:12
 * @description
 *
 * 17.2.1 一种Generator解决方案。
 *在前面16章中定义的所有操作符现在通过CollectionData适配器都是可能用的。
 * 下面是使用了其中两个操作符的示例。
 *
 */
public class CollectionDataGeneration {
    public static void main(String[] args) {
        System.out.println(new ArrayList<String>(CollectionData.list(new RandomGenerator.String(9),10)));
        System.out.println(new HashSet<Integer>(new CollectionData<Integer>(new RandomGenerator.Integer(),10)));


    }
}
