package jvm_demo.chapter13;
/**
 * 面试题2
 *
 * 如何保证变量s指向的是字符常量池中的数据呢？
 * 有两种方式
 * 方式一：String s = "shkstart"; // 字面量定义的方式
 * 方式二：调用intern()
 *      String s = new String("lhs").intern();
 *      String s = new StringBuilder("lhs").toString().intern();
 *
 * */
public class StringIntern1 {
    public static void main(String[] args) {
        String s = new String("1");
        //注意这里没有赋值回给s，如果是s = s.intern(); 结果肯定是true
        s.intern();//调用此方法之前，字符串常量池中已经存在了"1"
        String s2 = "1";
        System.out.println(s == s2); //jdk6:false   jdk7/8：false


        String s3 = new String("1") + new String("1");//s3变量记录的地址为：new String("11")
        //执行完上行代码后，字符串常量池中，是否存在"11"呢?答案：不存在！
        //注意这里没有赋值回给s3，如果是s3 = s3.intern(); 结果肯定是true
        s3.intern();//在字符串常量池中生成"11"
        // 如何理解  s3.intern(); ?
        // jdk6中：创建了一个新的对象"11"，也就有了新地址
        //jdk7中:此时常量池中并没有创建"11"，而是创建一个指向堆空间中new String("11")的地址
        String s4 = "11"; //s4变量的地址：使用的是上一行代码执行时，在常量池中生成的"11"地址
        System.out.println(s3 == s4); //jdk6:false   jdk7/8：true

    }
}
