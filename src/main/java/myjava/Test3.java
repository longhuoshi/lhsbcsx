package myjava;

import com.sun.deploy.util.StringUtils;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import entity.Student;
import org.w3c.dom.ls.LSOutput;

import javax.print.attribute.HashAttributeSet;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author l
 * @date 2021/3/4 16:10
 * @description
 */

public class Test3 {

    public static void main(String[] args) {
        //测试

//        List<String> aaa =strToListByComma("12,2,4,4565",String.class);
//        System.out.println(aaa);00000001632383300672
        System.out.println(1234);
        List<Student> a = new ArrayList(Arrays.asList(new Student(1,"a","boy"),
                new Student(2,"b","boy"),
                new Student(4,"d","girl"),
                new Student(3,"c","boy")));
        List<Student> b = new ArrayList(Arrays.asList(new Student(4,"d","girl"),
                new Student(5,"e","girl"),
                new Student(3,"c","boy")));
        List<Student> c = new ArrayList();
        for (Student i1 : a) {
            for (Student i2 : b) {
                if (i1.getId()  == i2.getId() )
                    c.add(i1);
            }
        }
        System.out.println(c);
        c.addAll(a);
        c.addAll(b);
        System.out.println(c);
        List<Student> collect = c.stream().distinct().collect(Collectors.toList());
        c.clear();
        c = collect;
        System.out.println(c);



    }


    /**
     *逗号隔成的字符串，根据 类型转换成相应的list
     *
     */
    public static  <T> List<T> strToListByComma(String str,Class<T> type){


        List<T> list = new ArrayList<T>();


        String[] strArr = str.split(",");
        boolean isInt = false;

        //注意这里不能用type.isInstance()
        if (type.isAssignableFrom(Integer.class))
            isInt = true;

        for (String temp : strArr){
            if (isInt)
                list.add(type.cast(Integer.parseInt(temp)));
            else
                list.add(type.cast(temp));
        }
        return list;
    }

}




