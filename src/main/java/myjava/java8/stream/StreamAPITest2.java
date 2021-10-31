package myjava.java8.stream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import myjava.java8.Employee;
import myjava.java8.EmployeeData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author l
 * @date 2021/10/27 17:24
 * @description
 *Stream的中间操作
 */
public class StreamAPITest2 {
    public static void main(String[] args) {
        //1、筛选与切片
//        test1();

        //2、映射
//        test2();

//        3、排序
        test3();
    }

    //1、筛选与切片
    private static void test1() {
        List<Employee> list = EmployeeData.getEmployee();
        Stream<Employee> stream = list.stream();

        stream.filter(e->e.getSalary()>7000).forEach(System.out::println);

        System.out.println("*********************");
        list.stream().limit(3).forEach(System.out::println);

        System.out.println("*********************");
        list.stream().skip(3).forEach(System.out::println);

        System.out.println("*********************");
        //筛选，通过流所生成元素的hashCode()和equals()去除重复元素。
        list.add(new Employee(1010,"东哥",47,4300.38));
        list.add(new Employee(1010,"东哥",47,4300.38));
        list.add(new Employee(1010,"东哥",47,4300.38));
        list.add(new Employee(1010,"东哥",47,4300.38));
        list.add(new Employee(1010,"东哥",47,4300.38));
        list.stream().distinct().forEach(System.out::println);
    }

    //2、映射
    private static void test2() {
        //接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "cc");
//        list.stream().map(str-> str.toUpperCase()).forEach(System.out::println);
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        System.out.println("********************");
        //练习：获取员工姓名长度大于3的员工的姓名 。
        List<Employee> employee = EmployeeData.getEmployee();
        Stream<String> nameStream = employee.stream().map(Employee::getName);
        nameStream.filter(name->name.length()>3).forEach(System.out::println);





        System.out.println("\n\n********** flatMap **********");
        //接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        //类比
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);
//        list1.add(list2); //out:[1, 2, 3, [4, 5, 6]]
        list1.addAll(list2); //out: [1, 2, 3, 4, 5, 6]
        System.out.println(list1);

        System.out.println("********************");
        //练习2：不用flatMap
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest2::fromStringToStream);
        streamStream.forEach(s->s.forEach(System.out::println));

        System.out.println("********************");
        //练习2：用flatMap 把fromStringToStream方法返回的stream流里
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest2::fromStringToStream);
        characterStream.forEach(System.out::println);


    }

    //        3、排序
    private static void test3() {
//        自然顺序排序。
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        list.stream().sorted().forEach(System.out::println);

        //ClassCastException :原因Employee没有实现Comparable接口
//        List<Employee> list1 = EmployeeData.getEmployee();
//        list1.stream().sorted().forEach(System.out::println);

        //定制排序
        List<Employee> list2 = EmployeeData.getEmployee();
//        list2.stream().sorted((e1,e2)->Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out::println);
        list2.stream().sorted((e1,e2)->{
            int result = Integer.compare(e1.getAge(),e2.getAge());
            if (result !=0){
                return result;
            }else {
                return - Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);


    }



    //将字符串转换成stream流
    public static Stream<Character> fromStringToStream(String str){

        List<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

}
