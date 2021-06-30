package bcsx.containers;

/**
 * @author l
 * @date 2020/10/15 14:18
 * @description
 *17.9.3 覆盖hashCode()
 * String有个特点 ：如果程序中有多个String对象，都包含相同的字符串序列，那么这些String对象都
 * 映射到同一块内存区域。所以new String("hello")生成两个实例，虽然都是独立的，但是对它们使用
 * hashCode()应该生成同样的结果。
 *
 */
public class StringHashCode {
    public static void main(String[] args) {
        String[] hellos = "Hello Hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
    }
}
