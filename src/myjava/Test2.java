package myjava;

import com.sun.deploy.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        List<Integer> list = new ArrayList<>();
        list.add(223);
        list.add(225);
        list.add(251);
        list.add(252);




        System.out.println(list.toString());

        //Integer 转String
        List<String> list3 = list.stream().map(Object::toString).collect(Collectors.toList());
        //逗号分隔String
//        System.out.println( String.join(",",list3));

    }


    public static String formatPointXX(BigDecimal source){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(source).toString();
    }



}
