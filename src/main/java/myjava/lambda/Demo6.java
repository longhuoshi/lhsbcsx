package myjava.lambda;

import java.util.Optional;

/**
 * @author l
 * @date 2019/12/12 15:49
 * @description
 *
 * Lambda配合Optional<T>可以使Java对于null的处理变的异常优雅
 *

 *
 */
public class Demo6 {
    static Person goAndGetAFuckingPerson(){
        return new Person("Naola","Suying",23);
    }

    public static void main(String[] args) {
        //* 这里假设我们有一个person object，以及一个person object的Optional wrapper:
        Person person =  goAndGetAFuckingPerson();
        //大前提，要创建 Optional<Person> 对象
        Optional<Person> personOpt = Optional.ofNullable(person);


        /**
         * 只有当Optional<T>结合Lambda一起使用的时候，才能发挥出其真正的威力！
         *
         * 我们现在就来对比一下下面四种常见的null处理中，Java 8的Lambda+Optional<T>和传统Java两者之间对于null的处理差异。
         *
         * 情况一 - 存在则开干
         *
         * */
        //        java8
        personOpt.ifPresent(System.out::println);

//        java7
        if(person!=null){
            System.out.println(person);
        }


        //情况二 - 存在则返回，无则返回屁
        System.out.println(condition2(personOpt,person));

        System.out.println(condition3(personOpt,person));

        System.out.println(condition4(personOpt,person));

    }


    //Optional<T>如果不结合Lambda使用的话，并不能使原来繁琐的null check变的简单。
    private static Person UNKNOWN_PERSON = new Person("无姓","无名",0);
    //same shit
    public static Person objIsNullOpt(Optional<Person> personOpt){

        if(personOpt.isPresent())
            return personOpt.get();
        else
            return UNKNOWN_PERSON;
    }
    //same shit
    public static Person objIsNull(Person person){

        if(person != null)
            return person;
        else
            return UNKNOWN_PERSON;
    }


    //情况二 - 存在则返回，无则返回屁
    public static Person condition2(Optional<Person> personOpt,Person person){

        //jav8
        return personOpt.orElse(UNKNOWN_PERSON);

        //java7
   /*     if(person != null)
            return person;
        else
            return UNKNOWN_PERSON;*/

    }
    //情况三 - 存在则返回，无则由函数产生
    public static Person condition3(Optional<Person> personOpt,Person person){

        //jav8
        return personOpt.orElseGet(()->goAndGetAFuckingPerson());

        //java7
    /*    if(person != null)
            return person;
        else
            return goAndGetAFuckingPerson();*/

    }

    //情况四 - 夺命连环null检查
    public static String condition4(Optional<Person> personOpt,Person person){

        //jav8
//        return personOpt.map(p->p.getLastName()).map(lastName->lastName.toUpperCase()).orElse(null);

        //java7
        if(person != null){
            String name = person.getLastName();
            if(name !=null)
                return name.toUpperCase();
            else
                return null;
        }
        else
            return null;


    }

}

/**
 * 由上述四种情况可以清楚地看到，Optional<T>+Lambda可以让我们少写很多ifElse块。尤其是对于情况四那种夺命连环null检查，
 * 传统java的写法显得冗长难懂，而新的Optional<T>+Lambda则清新脱俗，清楚简洁。
 *
 *
 * */