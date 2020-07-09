package bcsx.generics;

/**
 * @author l
 * @date 2020/7/2 14:18
 * @description
 *
 * 15.11.5 基类劫持了接口
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

