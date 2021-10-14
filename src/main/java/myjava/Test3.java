package myjava;

import com.sun.deploy.util.StringUtils;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
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
        System.out.println(123);
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




