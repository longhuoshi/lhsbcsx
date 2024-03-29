package bcsx.main.java.generics.decorator;

import java.util.Date;

/**
 * @author l
 * @date 2020/7/16 10:25
 * @description
 *
 *15.15.3 使用装饰器模式
 */

class Basic{
    private String value;
    public void set(String val){ value = val; }
    public String get(){ return value; }
}

class Decorator extends Basic{
    protected Basic basic;
    public Decorator(Basic basic){ this.basic = basic ; }
    public void set(String val){ basic.set(val); }
    public String get(){ return basic.get(); }
}

class TimeStamped extends Decorator{
    private final long timeStamp;
    public TimeStamped(Basic basic) {
        super(basic);
        timeStamp = new Date().getTime();
    }
    public long getTimeStamp(){
        return timeStamp;
    }
}

class SerialNumbered extends Decorator{
    private static long counter = 1;
    private final long serialNumber = counter++;
    public SerialNumbered(Basic basic){ super(basic); }

    public long getSerialNumber(){
        return serialNumber;
    }
}


public class Decoration {
    public static void main(String[] args) {
        TimeStamped t = new TimeStamped(new Basic());
        TimeStamped t2 = new TimeStamped(new SerialNumbered(new Basic()));
        //! t2.getSerialNumber();  //Not available
        System.out.println(t2.getTimeStamp());

        SerialNumbered s = new SerialNumbered(new Basic());
        SerialNumbered s2 = new SerialNumbered(new TimeStamped(new Basic()));
        // s2.getTimeStamp();  //Not available
        System.out.println(s.getSerialNumber());


    }
}
