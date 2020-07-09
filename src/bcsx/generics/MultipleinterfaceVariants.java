package bcsx.generics;

/**
 * @author l
 * @date 2020/6/18 13:58
 * @description
 * {compileTimeError} (Won't compile)
 * 15.11.2 实现参数化接口
 */

interface Payable<T>{}

class Employee2 implements Payable<Employee2>{}
class Hourly extends Employee implements Payable<Hourly>{}

