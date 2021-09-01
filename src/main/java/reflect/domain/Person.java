package reflect.domain;

public class Person {
    private String name;
    private int age;

    public Person() {
        System.out.println("person run");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("person run name:"+name);
    }

    public void show(){
        System.out.println("person show run");
    }
    public static void staticShow(){
        System.out.println("person staticShow run");
    }
    public void paramShow(String name,int age){
        System.out.println("show:"+name+"---"+age);
    }

}
