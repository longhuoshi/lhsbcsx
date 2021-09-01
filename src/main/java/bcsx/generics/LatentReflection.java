package bcsx.generics;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static bcsx.net.mindview.util.Print.*;
/**
 * @author l
 * @date 2020/7/29 15:26
 * @description
 *
 * 15.17 对缺乏潜在类型机制的补尝
 * 15.17.1 反射
 *
 *
 */

class Mime{
    public void walkAgainstTheWind(){ }
    public void sit(){print("Pretending to sit");}
    public void pushInvisibleWalls(){}
    public String toString(){ return "Mime";}
}

class SmartDog{
    public void speak(){print(" Woof! ");}
    public void sit(){print("Sitting");}
    public void reproduce(){}
}

class CommunicateReflectively{
    public static void perform(Object speaker){
        Class<?> spkr = speaker.getClass();
        try {
            try {
                Method speak =  spkr.getMethod("speak");
                speak.invoke(speaker);

            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
                print(speaker + " cannot speak");
            }
            try {
            Method sit = spkr.getMethod("sit");
                sit.invoke(speaker);
            } catch (NoSuchMethodException e) {
                print(speaker + " cannot sit");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}

public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Robot());
        CommunicateReflectively.perform(new Mime());

    }
}
