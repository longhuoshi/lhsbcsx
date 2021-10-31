package myjava.java8.stream;

import myjava.java8.Employee;
import myjava.java8.EmployeeData;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author l
 * @date 2021/10/27 17:24
 * @description
 * 创建Stream方式之一：通过集合
 * java8中的Collection接口被扩展，提供了两个获取流的方法：
 * default Stream<E> stream() 返回一个顺序流
 * default Stream<E> parallelStream() 返回一个并行流
 *
 * 创建steam方式2  数组
 *
 * //创建steam方式3
 * Stream.of(1, 2, 3, 4);
 *
 * 创建无限流
 */
public class StreamAPITest {
    public static void main(String[] args) {

        otherTest();


        //创建steam方式3
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
    }

    //创建steam方式1  集合s
    public static void test1(){
        //集合stream
        List<Employee> employees = EmployeeData.getEmployee();
        //返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }
    //创建steam方式2  数组
    public static void test2(){
        //数组stream
        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1002,"Ariana Grande");
        Employee[] arr1 = new Employee[]{e1,e2};
        Stream<Employee> stream = Arrays.stream(arr1);

    }

    //创建steam方式4 :创建无限流
    public static void otherTest(){
        //迭代
        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //void forEach(Consumer<? super T> action)
        //forEach方法是终止stream流
        //遍历前10个偶数
        Stream.iterate(0,t -> t+2).limit(10).forEach(item-> System.out.println(item));

        //生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);


    }
}
