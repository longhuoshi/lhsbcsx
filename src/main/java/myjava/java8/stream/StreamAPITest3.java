package myjava.java8.stream;

import myjava.java8.Employee;
import myjava.java8.EmployeeData;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author l
 * @date 2021/10/27 17:24
 * @description
 *练习
 */
public class StreamAPITest3 {
    public static void main(String[] args) {
//        test1();
        test2();



    }

    private static void test2() {
        //收集collect(Collector c) 将流转换为其它形式。接受一个Collector接口实现，用于给Stream中元素做汇总的方法。
        //练习1：查找工资大于6000的员工 ，结果返回为一个list或set
        List<Employee> list = EmployeeData.getEmployee();
        List<Employee> collectList = list.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        collectList.forEach(System.out::println);
        System.out.println("*********************");
        Set<Employee> collectSet = list.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        collectSet.forEach(System.out::println);

    }

    //计算总数 ，最大值 ，最小值
    private static void test1() {
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
