package generics.demo01;

/**
 * @author l
 * @date 2021/11/25 9:52
 * @description
 */
public class MiniCat extends Cat {
    public int level;

    public MiniCat(String name, int age, int level) {
        super(name, age);
        this.level = level;
    }

    @Override
    public String toString() {
        return "MiniCat{" +
                "level=" + level +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
