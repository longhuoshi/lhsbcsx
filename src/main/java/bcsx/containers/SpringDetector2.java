package bcsx.containers;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import static bcsx.net.mindview.util.Print.print;

/**
 * @author l
 * @date 2020/10/9 14:28
 * @description
 *
 * 17.9 散列与散列码
 *
 * Groundhog自动继承了基类Object，所以这里使用了Object的hashCode()方法生成散列码，
 * 而它默认是对象的地址计算散列码。
 * 但这里直接覆盖hashCode()不行，还要同时覆盖equals()方法。才能找到Groundhog #3
 *
 */
public class SpringDetector2 {
    public static void main(String[] args)throws Exception  {
        bcsx.containers.SpringDetector.detectSpring(bcsx.containers.Groundhog2.class);
    }
}
