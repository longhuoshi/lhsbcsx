package bcsx.generics;

import bcsx.typeinfo.pets.Dog;
import static bcsx.net.mindview.util.Print.*;

/**
 * @author l
 * @date 2020/7/27 15:43
 * @description
 *
 * 15.16 潜在类型机制
 *
 *
 */

class PerformingDog extends Dog implements Performs{

    @Override
    public void speak() {
        print("Woof!");
    }

    @Override
    public void sit() {
        print("Sitting");
    }
    public void reproduce(){}
}

class Robot implements Performs{

    @Override
    public void speak() {
        print("Click");
    }

    @Override
    public void sit() {
        print("Clank!");
    }
    public void oilChange(){}
}

class Communicate{
    public static <T extends Performs> void perform(T performer){
        performer.speak();
        performer.sit();
    }
}


public class DogsAndRobots {
    public static void main(String[] args) {
        PerformingDog pd = new PerformingDog();
        Robot robot = new Robot();
        Communicate.perform(pd);
        Communicate.perform(robot);

    }
}
