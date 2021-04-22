package bcsx.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author l
 * @date 2020/9/18 16:43
 * @description
 * 第17章 容器深入研究
 * 17.1 完整的容器分类法
 * 17.2 填充容器
 *
 */

class StringAddress{
    private String s;
    public StringAddress(String s){this.s = s;}
    public String toString(){
        return super.toString()+" "+s;
    }
}

public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<>(Collections.nCopies(4,new StringAddress("Hello")));
        System.out.println(list);
        Collections.fill(list,new StringAddress("world!"));
        System.out.println(list);



    }
}
