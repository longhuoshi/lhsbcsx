package main.java.main.java.myjava.covariant;

/**
 * @author l
 * @date 2019/12/13 15:24
 * @description
 *
 * 协变类型
 *
 * 1、协变类型返回也是覆盖方法的一种，jdk5开始支持的一种:子类覆盖方法返回可以是子类返回的子类,这个比较拗口
 *
 * 2、Java5.0放宽了这一限制，只要子类方法与超类方法具有相同的方法签名，或者子类方法的返回值是超类方法返回类型的子类型，就可以覆盖。
 */

/**
 * 粮食类
 */
class Grain{
    public String toString(){
        return "Grain";
    }
}
/**
 * 小麦类
 */
class Wheat extends Grain{
    public String toString(){
        return "Wheat";
    }
}

/**
 *协变返回
 * 子类覆盖方法返回可以是子类返回的子类
 */
class Mill{
    public Grain process(){
        return new Grain();
    }
}

class WheatMill extends Mill{
    @Override
    public Wheat process(){
        //注意这里，这里就是协变返回类型
        //导出类（子类）覆盖（即重写）基类（父类）方法时，
        //返回的类型可以是基类方法返回类型的子类
        //	WheatMill    -->Mill
        // Wheat --> Grain
        return new Wheat();
    }
}

public class Covariant {
    public static void main(String[] args) {
        Mill mill = new Mill();
        System.out.println(mill.process());
        Mill wmill = new WheatMill();
        System.out.println(wmill.process());


    }

}
