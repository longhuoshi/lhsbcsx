package bcsx.containers;

import java.util.*;

import static bcsx.net.mindview.util.Print.*;

/**
 * @author l
 * @date 2020/11/24 10:30
 * @description
 * 17.11.1 List的排序与查询
 */
public class ListSortSearch {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Utilities.list);
        list.addAll(Utilities.list);
        print(list);
        Collections.shuffle(list,new Random(47));
        print("Shuffled: " + list);
        // Use a ListIterator to trim off the last elements:
        ListIterator  it = list.listIterator(10);
        while (it.hasNext()){
            it.next();
            it.remove();
        }
        print("Trimmed: " + list);
        Collections.sort(list);
        print("Sorted: " + list);
        String key = list.get(7);
        int index = Collections.binarySearch(list,key);
        print("Location of " + key + " is " + index + ", list.get(" + index + ") = " + list.get(index));
        Collections.sort(list,String.CASE_INSENSITIVE_ORDER);
        print("Case-insensitive sorted: " + list);
        key = list.get(7);
        index = Collections.binarySearch(list,key,String.CASE_INSENSITIVE_ORDER);
        print("Location of " + key + " is " + index + ", list.get(" + index + ") = " + list.get(index));


    }
}
