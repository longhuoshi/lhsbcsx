package myjava.java8.optional;

/**
 * @author l
 * @date 2021/11/1 14:41
 * @description
 */
public class Girl {
    private String name;

    public Girl() {
    }

    public Girl(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
