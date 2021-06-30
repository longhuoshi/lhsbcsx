package bcsx.containers;

/**
 * @author l
 * @date 2020/10/9 14:15
 * @description
 * 17.9 散列与散列码
 */
public class Groundhog2 extends Groundhog {
    public Groundhog2(int n) {
        super(n);
    }
    public int hashCode(){return number; }
    public boolean equals(Object o){
        return o instanceof Groundhog2 && (number == ((Groundhog2)o).number);
    }

}
