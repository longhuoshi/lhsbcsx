package bcsx.containers;

import java.util.Random;

/**
 * @author l
 * @date 2020/10/9 14:17
 * @description
 * 17.9 散列与散列码
 */
public class Prediction {
    private static Random rand = new Random(47);
    private boolean shadow = rand.nextDouble() > 0.5 ;
    public String toString(){
        if(shadow)
            return "Six more weeks of Winter!";
        else
            return "Early Spring! ";
    }

}
