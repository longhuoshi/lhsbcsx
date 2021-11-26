package generics.demo01;

/**
 * @author l
 * @date 2021/11/25 9:51
 * @description
 */
public class Cat extends Animal {

    public int age;

    public Cat(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
