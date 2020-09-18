package bcsx.arrays;

import bcsx.net.mindview.util.Generated;

import java.util.*;

import static bcsx.net.mindview.util.Print.*;

/**
 * @author l
 * @date 2020/9/3 15:54
 * @description
 *
 *
 * @                           _ooOoo_
 *                            o8888888o
 *                            88" . "88
 *                            (| -_- |)
 *                            O\  =  /O
 *                         ____/`---'\____
 *                       .'  \\|     |//  `.
 *                      /  \\|||  :  |||//  \
 *                     /  _||||| -:- |||||-  \
 *                     |   | \\\  -  /// |   |
 *                     | \_|  ''\---/''  |   |
 *                     \  .-\__  `-`  ___/-. /
 *                   ___`. .'  /--.--\  `. . __
 *                ."" '<  `.___\_<|>_/___.'  >'"".
 *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *               \  \ `-.   \_ __\ /__ _/   .-` /  /
 *          ======`-.____`-.___\_____/___.-`____.-'======
 *                             `=---='
 *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *                     佛祖保佑        永无BUG
 *
 * 16.7.3 数组元素的比较.
 *
 * 也可以自己编写一个Comparator
 *
 */

class CompTypeComparator implements Comparator<CompType> {
    @Override
    public int compare(CompType o1, CompType o2) {
        return o1.j<o2.j ? -1 : (o1.j == o2.j ? 0 : 1);
    }
}

public class ComparatorTest {
    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12],CompType.generator());
        print("before sorting:");
        print(Arrays.toString(a));
        Arrays.sort(a,new CompTypeComparator());
        print("after sorting:");
        print(Arrays.toString(a));


    }
}
