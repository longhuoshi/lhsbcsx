package myjava.java8.stream;

import myjava.java8.Employee;
import myjava.java8.EmployeeData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author l
 * @date 2021/10/27 17:24
 * @description
 *练习
 */
public class StreamAPITest3 {
    public static void main(String[] args) {
        List<Employee> list = EmployeeData.getEmployee();

        //count 返回流中元素总数
        long count = list.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);
        //max返回流中最大值
        //返回最高的工资
//        Optional<Double> max = list.stream().map(e -> e.getSalary()).max(Double::compare);
        Stream<Double> doubleStream = list.stream().map(e -> e.getSalary());
        Optional<Double> max = doubleStream.max(Double::compare);
        System.out.println(max);
        //返回最低工资的员工
        Optional<Employee> min = list.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);


    }

}
