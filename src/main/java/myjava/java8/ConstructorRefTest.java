package myjava.java8;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author l
 * @date 2021/10/27 15:51
 * @description
 * 一、构造器引用
 *
 * 二、数组引用
 *  大家可以把数组看做是一个特殊的类，则写法与构造器引用一致。
 *
 */
public class ConstructorRefTest {
    public static void main(String[] args) {
        ConstructorRefTest c = new ConstructorRefTest();
//        c.test1();
//        c.test2();
//        c.test3();
        c.test4();
    }
    //构造器引用
    //Supplier中的T get();
    //Employee的空构造方法：Employee();
    public void test1(){
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };

        System.out.println("********************");
        Supplier<Employee> sup2 = ()->new Employee();
        System.out.println(sup2.get());

        System.out.println("********************");
        Supplier<Employee> sup3 = Employee::new;
        System.out.println(sup3.get());

    }
    //Function中的R apply(T t);
    public void test2(){
        Function<Integer,Employee> func1 = (id)->new Employee(id);
        System.out.println(func1.apply(1001));

        System.out.println("********************");
        Function<Integer,Employee> func2 = Employee::new;
        System.out.println(func2.apply(1001));

    }

    //BiFunction中的R apply(T t, U u);
    public void test3(){
        BiFunction<Integer,String,Employee> func1 = (id,name)->new Employee(id,name);
        System.out.println(func1.apply(1001,"李云迪"));

        System.out.println("********************");
        BiFunction<Integer,String,Employee> func2 = Employee::new;
        System.out.println(func2.apply(1002,"吴亦凡"));

    }

    //Function中的R apply(T t);
    public void test4(){
        Function<Integer,String[]> func1 = length->new String[length];
        String[] arr1 = func1.apply(4);
        System.out.println(Arrays.toString(arr1));
        System.out.println("********************");
        Function<Integer,String[]> func2 = String[]::new;
        String[] arr2 = func2.apply(8);
        System.out.println(Arrays.toString(arr2));


    }




}
