package myjava.lambda;



import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author l
 * @date 2019/12/12 11:18
 * @description
 *
 * 这个代码实际上已经比较简洁了，但是我们还可以更简洁么？
 *
 * 答案是可以的如下 ：
 *
 *当然可以。在Java 8中有一个函数式接口的包，里面定义了大量可能用到的函数式接口
 * （java.util.function (Java Platform SE 8 )） https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
 * 所以，我们在这里压根都不需要定义NameChecker和Executor这两个函数式接口，直接用Java 8函数式接口包里的Predicate<T>和Consumer<T>
 *  就可以了——因为他们这一对的接口定义和NameChecker/Executor其实是一样的。
 *
 *
 *
 * @FunctionalInterface
 * interface Predicate<T>{
 *     boolean test(T t);
 * }
 * 对应
 *@FunctionalInterface
 * interface NameChecker{
 *     boolean cehck(Person p);
 * }
 *
 *
 * @FunctionalInterface
 * interface Consumer<T>{
 *     void acceot(T t);
 * }
 * 对应
 * @FunctionalInterface
 * interface Executor{
 *     void execute(Person p);
 * }
 *
 *
 */



public class Demo5 {
    public static void checkAndExecutor(List<Person> personList,
                                        Predicate<Person> predicate,
                                        Consumer<Person> consumer){
        //第二步简化 - 用Iterable.forEach()取代foreach loop：
        personList.forEach(p->{
            if (predicate.test(p))
                consumer.accept(p);
        });




    }

    public static void main(String[] args) {
        List<Person> guiltyPersons = Arrays.asList(
                new Person("Yixing","Zhao",25),
                new Person("Yanggui","Li",30),
                new Person("MeiNv","Jing",30),
                new Person("Chao","Ma",29)
        );

        checkAndExecutor(guiltyPersons,
                p->p.getLastName().startsWith("Z"),
                p-> System.out.println(p.getFirstName()));



        //第三步简化 - 利用stream()替代静态函数checkAndExecutor：
        guiltyPersons.stream()
                .filter(p->p.getLastName().startsWith("M"))
                .forEach(p-> System.out.println(p.getFirstName()));


        /**
         * 对比最开始的Lambda写法，这里已经非常非常简洁了。但是如果，我们的要求变一下，变成print这个人的全部信息，
         * 及p -> System.out.println(p); 那么还可以利用Method reference来继续简化。所谓Method reference,
         * 就是用已经写好的别的Object/Class的method来代替Lambda expression。格式如下：
         * Object::methodName 或 Class::staticMethod
         *
         *第四步简化 - 如果是println(p)，则可以利用Method reference代替forEach中的Lambda表达式：
         *这基本上就是能写的最简洁的版本了。
         * */
        guiltyPersons.stream()
                .filter(p->p.getLastName().startsWith("Z"))
                .forEach(System.out::println);


        List<String> nameList = guiltyPersons.stream()
                .filter(item->item.getAge() == 30 )   // 过滤条件
                .limit(2)    // limit限制条件
                .map(lhs->lhs.getLastName())  // 获得姓名
                .collect(Collectors.toList()); // 转化为list
        System.out.println(nameList);


    }
}
