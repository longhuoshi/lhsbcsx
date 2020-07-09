package bcsx.generics;

/**
 * @author l
 * @date 2020/6/19 16:56
 * @description
 * 15.11.5 基类劫持了接口
 */
public class ComparablePet implements Comparable<ComparablePet>{


    @Override
    public int compareTo(ComparablePet arg) {
        return 0;
    }
}
