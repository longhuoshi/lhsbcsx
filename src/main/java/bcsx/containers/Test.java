package bcsx.containers;

/**
 * @author l
 * @date 2020/10/16 10:27
 * @description
 * 17.10 选择接口的不同实现
 * 17.10.1 性能测试框架
 */
public abstract class Test<C> {
    String name;
    public Test(String name){
        this.name = name;
    }
    // Override this method for different tests.
    // Returns actual number of repetitions of test.
    abstract int test(C container , TestParam tp);
}
