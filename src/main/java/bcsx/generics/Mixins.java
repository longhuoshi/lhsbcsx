package bcsx.generics;

import java.util.Date;

/**
 * @author l
 * @date 2020/7/15 14:34
 * @description
 * 15.15.2 与接口混合
 *
 * 一种常见的推荐解决方案是使用接口来产生混型效果
 *
 *
 * 这里的Mixin类基本上是在使用代理。因此每个混入类型都要求在Mixin中有一个相应的域。
 *
 * 这种方式不足点：当使用更复杂的混型时，代码数量会急速增加.
 *
 */

interface TimeStamped { long getStamp();}
class TimeStampedImp implements TimeStamped{
    private final long timeStamp;
    public TimeStampedImp(){
        timeStamp = new Date().getTime();
    }
    @Override
    public long getStamp() {
        return timeStamp;
    }
}

interface SerialNumbered { long getSerialNumber();}
class SerialNumberedImp implements SerialNumbered{
    private static long counter = 1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Basic{
    public void set(String val);
    public String get();
}

class BasicImp implements Basic{
    private String value;
    @Override
    public void set(String val) {
        this.value = val;
    }

    @Override
    public String get() {
        return value;
    }
}

class Mixin extends BasicImp implements TimeStamped,SerialNumbered{
    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();


    @Override
    public long getStamp() {
        return timeStamp .getStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }
}


public class Mixins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin(),mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.get()+" " + mixin1.getStamp()+" "+mixin1.getSerialNumber());
        System.out.println(mixin2.get()+" " + mixin2.getStamp()+" "+mixin2.getSerialNumber());

    }
}
