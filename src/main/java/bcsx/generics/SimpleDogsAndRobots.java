package bcsx.generics;

/**
 * @author l
 * @date 2020/7/29 14:46
 * @description
 * 15.16 潜在类型机制
 */


class CommunicateSimply{
    static void perform(Performs performer){
        performer.speak();
        performer.sit();
    }
}

public class SimpleDogsAndRobots {
    public static void main(String[] args) {
        CommunicateSimply.perform(new PerformingDog());
        CommunicateSimply.perform(new Robot());
    }
}
