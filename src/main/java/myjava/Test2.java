package myjava;

import com.sun.deploy.util.StringUtils;
import entity.Student;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
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


        HashSet<Integer> aaa = new HashSet<>();
        aaa.add(new Integer(2));
        aaa.add(new Integer(2));
        aaa.add(new Integer(3));
        aaa.add(4);
        aaa.add(4);
        aaa.add(5);
        System.out.println(aaa);

        List<String> list4 = aaa.stream().map(Object::toString).collect(Collectors.toList());
        System.out.println(String.join(",",list4));

        Test2 test2 = new Test2();
        test2.s1 = new Student(1,"tom","girl");
        test2.s2 = test2.s1;
        System.out.println(test2.s1 );
        test2.s1 =null;
        System.out.println(test2.s2 );



    }
    private Student s1;
    private Student s2;


    public static String formatPointXX(BigDecimal source){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(source).toString();
    }



}
