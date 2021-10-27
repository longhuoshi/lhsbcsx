package myjava.java8;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author l
 * @date 2021/10/27 14:43
 * @description
 * 方法引用 (Method References)
 * 类(或对象) :: 方法名
 * 示例：
 * Consumer中的void accept(T t)
 * PrintStream 中的void println(T t)
 *
 *三种情况
 * 1、对象::非静态方法
 * 2、类::静态方法
 * 3、类::非静态方法
 */
public class MethodRefTest {

    public static void main(String[] args) {
        MethodRefTest test = new MethodRefTest();
//        test.test1();
//        test.test2();
//        test.test3();
//        test.test4();
//        test.test5();
        test.test6();



    }

    /**
     * 示例1、对象::实例方法
     * Consumer中的void accept(T t)
     *  PrintStream 中的void println(T t)
     * */
    public void test1(){

        Consumer<String> con1 = str-> System.out.println(str);
        con1.accept("北京");

        System.out.println("********************");
        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("beijing");


    }

    /**
     * 示例2、类::静态方法
     * Comparator中的int compare(T o1, T o2);
     * Integer 中的int compare(int x, int y)
     * */
    public void test2(){

        Comparator<Integer> com1 = (t1,t2)->Integer.compare(t1,t2);
        System.out.println(com1.compare(12,21));

        System.out.println("********************");
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(12,3));
    }

    /**
     * 示例3、类::实例方法(返回类型、参数类型、参数个数对应。)
     * Function中的R apply(T t);
     * Integer 中的long round(double a)
     * */
    public void test3(){
        Function<Double,Long> func = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };

        System.out.println("********************");
        Function<Double,Long> func2 = a-> Math.round(a);
        System.out.println(func2.apply(23.2));

        System.out.println("********************");
        Function<Double,Long> func3 = Math::round;
        System.out.println(func3.apply(23.6));
    }


    /**
     * 示例4、类::实例方法(参数不一致时，第一个参数当作方法的调用 者)
     * Comparator中的int compare(T o1, T o2)
     * String 中的int o1.compareTo(o2)
     * */
    public void test4(){
        Comparator<String> com1 = (s1,s2)->s1.compareTo(s2);
        System.out.println(com1.compare("abc","abd"));

        System.out.println("********************");
        Comparator<String> com2 = String::compareTo; //String:: 这里的String就是参数1所在的位置 。
        System.out.println(com2.compare("abd","abm"));

    }
    /**
     *
     * BiPredicate中的boolean test(T t1, U t2);
     * String 中的boolean t1.equals(t2)
     * */
    public void test5(){
        BiPredicate<String,String> pre1 = (s1,s2) -> s1.equals(s2);
        System.out.println(pre1.test("abc","abc"));

        System.out.println("********************");
        BiPredicate<String,String> pre2 = String::equals;
        System.out.println(pre2.test("abc","abd"));

    }

    /**
     *
     * Function中的 R apply(T t);
     * Employee 中的String getName();
     * */
    public void test6(){
        Employee employee = new Employee(1001,"Jerry",23,6000);

        Function<Employee,String> func1 = e->e.getName();
        System.out.println(func1.apply(employee));

        System.out.println("********************");
        Function<Employee,String> func2 = Employee::getName;
        System.out.println(func2.apply(employee));

    }
}
