package myjava;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author l
 * @date 2020/6/29 16:10
 * @description
 */
class Person8{
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class Test2 {

    public static void main(String[] args) {
        //测试
        BigDecimal financeToAccountDto = new BigDecimal(4004.01);
        System.out.println(formatPointXX(financeToAccountDto));
        Person8 p = new Person8();
        p.setName(p.getName()+"dasfasdf");
        p.setName(p.getName()+"123");
        p.setName(p.getName()+"哈哈");
        System.out.println(p.getName());

    }


    public static String formatPointXX(BigDecimal source){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(source).toString();
    }



}
