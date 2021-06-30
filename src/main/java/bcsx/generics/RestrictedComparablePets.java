package bcsx.generics;

/**
 * @author l
 * @date 2020/7/2 14:18
 * @description
 *
 * 15.11.5 基类劫持了接口
 * previous {@link Cat}
 * next {@link CuriouslyRecurringGeneric  }
 * 如果泛型参数，精确地相同，包括参数类型在内。就可以实现相同泛型接口的。
 * 这与覆盖基类的方法相同。
 */
class Hamster extends  ComparablePet implements Comparable<ComparablePet>{
    public int compareTo(ComparablePet arg){
        return 0;
    }

}

//or just

class Gecko extends ComparablePet{
    public int compareTo(ComparablePet arg){
        return 0;
    }
}

