package generics.demo01;

import java.util.ArrayList;

/**
 * @author l
 * @date 2021/11/25 15:05
 * @description
 * 泛型与数组
 */
public class GenericAndArray {
    public static void main(String[] args) {
//        ArrayList<String>[] listArr = new ArrayList<String>[5];//error Generic array creation



        unsafe();

    }

    private static void safe() {
        ArrayList<String>[] listArr = new ArrayList[5];
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(100);

        ArrayList<String> strList = new ArrayList<>();
        strList.add("abc");
//        listArr[0] = intList;
        listArr[0] = strList;
        String s = listArr[0].get(0);
        System.out.println(s);
    }

    public static void unsafe(){

        ArrayList[] list = new ArrayList[5];
        ArrayList<String>[] listArr = list;  //不安全

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(100);

        list[0] = intList;//绕过泛型数组给普通数组赋值。
        String s = listArr[0].get(0);
        System.out.println(s);



    }
}
