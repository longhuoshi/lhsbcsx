package bcsx.generics;

/**
 * @author l
 * @date 2020/6/18 13:58
 * @description
 * 一个类不能实现同一个泛型接口的两种变体 。由于擦除原因，这两种变体 会变成相同的接口。
 * {compileTimeError} (Won't compile)
 * 15.11.2 实现参数化接口
 * previous {@link PrimitiveGenericTest}
 * next {@link  GenericCast}
 *
 */
public class MultipleinterfaceVariants{}

interface Payable<T>{}

class Employee2 implements Payable<Employee2>{}
//class Hourly extends Employee2 implements Payable<Hourly>{}
//如果Payable这两种用法，后面的泛型都去掉。又可以编译。


