package bcsx.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author l
 * @date 2020/6/17 15:24
 * @description
 * 15.11.1 任何基本类型都不能作为类型参数 。 因此不能创建ArrayList<int>
 */
public class ListOfInt {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            li.add(i);
        }

        for (int i:li)
            System.out.print(i + " ");

    }


}
