package main.java.myjava.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author l
 * @date 2019/12/12 10:14
 * @description
 *
 * Lambda结合FunctionalInterface Lib, forEach, stream()，method reference等新特性可以使代码变的更加简洁！
 */


class Person{
    public Person(String firstName,String lastName,int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

    }
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }

    public String toString(){
        return "name:"+firstName+lastName+" age:"+age;
    }
}

@FunctionalInterface
interface NameChecker{
    boolean cehck(Person p);
}

@FunctionalInterface
interface Executor{
    void execute(Person p);
}

public class Demo4 {

    public static void  checkAndExecutor(List<Person> personList,
                                         NameChecker nameChecker,
                                         Executor executor){
        for (Person p : personList){
            if(nameChecker.cehck(p))
                executor.execute(p);
        }
    }


    public static void main(String[] args) {
        List<Person> guiltyPersons = Arrays.asList(
                new Person("Yixing","Zhao",25),
                new Person("Yanggui","Li",30),
                new Person("Chao","Ma",29)
        );

        //这个代码实际上已经比较简洁了，但是我们还可以更简洁么？
        checkAndExecutor(guiltyPersons,
                p->p.getLastName().startsWith("Z"),
                param->System.out.println(param.getFirstName()));




    }

}
