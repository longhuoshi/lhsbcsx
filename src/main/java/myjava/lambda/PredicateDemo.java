package myjava.lambda;

import entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    public static List<Student> filter(List<Student> list , Predicate<Student> predicate){
        List<Student> newList = new ArrayList<>();
        list.forEach(student -> {
            if (predicate.test(student))
                newList.add(student);
        });

        return newList;
    }

    public static void main(String[] args) {
         List<Student> list = new ArrayList<>();
         list.add(new Student(1,"张三","M"));
         list.add(new Student(2,"李四","M"));
         list.add(new Student(3,"王五","F"));
        List<Student> f = filter(list, s -> s.getSex().equals("M"));
        System.out.println(f);

    }
}
