package myjava.java8.stream;

import myjava.java8.Employee;
import myjava.java8.EmployeeData;

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
 */
public class StreamAPITest {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeData.getEmployee();
        //返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();



    }
}
