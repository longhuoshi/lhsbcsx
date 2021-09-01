package bcsx.arrays;

import bcsx.net.mindview.util.CountingGenerator;
import bcsx.net.mindview.util.Generator;

import java.sql.SQLOutput;

/**
 * @author l
 * @date 2020/8/20 15:06
 * @description
 *
 * 16.6.2 数据生成器
 */
public class GeneratorsTest {
    public static int size = 10;
    public static void test(Class<?> surroundingClass){
        for (Class<?> type : surroundingClass.getClasses()){ //得到每个确切的类
            System.out.print(type.getSimpleName()+": ");
            try {
                Generator<?> g = (Generator<?>)type.newInstance();//用多态，把确切的类转换成接口类型。
                for (int i = 0; i < size; i++) {
                    System.out.print(g.next()+" ");
                }
                System.out.println();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        test(CountingGenerator.class);

    }
}
