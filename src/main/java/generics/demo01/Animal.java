package generics.demo01;

/**
 * @author l
 * @date 2021/11/25 9:51
 * @description
 */
public class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
