package myjava.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author l
 * @date 2021/10/27 15:40
 * @description
 */
public class EmployeeData {
    public static List<Employee> getEmployee(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001,"马化腾",34,6000.38));
        list.add(new Employee(1002,"马云",12,9876.38));
        list.add(new Employee(1003,"刘强东",33,5002.38));
        list.add(new Employee(1004,"雷军",26,76323.38));
        list.add(new Employee(1005,"奶茶妹",22,3000.38));
        list.add(new Employee(1006,"比尔盖次",47,9998.38));
        list.add(new Employee(1007,"扎克伯格",35,8300.38));

        return list;
    }
}
