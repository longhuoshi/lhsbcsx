package jvm_demo.chapter13;

public class StringTest5 {
    public static void main(String[] args) {
        StringTest5 s = new StringTest5();
        s.Test5();
    }
    public void test1(){
        String s1 = "a" + "b"+"c"; //编译期优化:等同于"abc"
        String s2 = "abc";//s2一定是放在字符串常量池中，将此地址赋给s2
        /**
         * 最终.java编译成.class，再执行.class
         * String s1 = "abc";
         * String s2 = "abc";
         * */
        System.out.println(s1 == s2); //true
        System.out.println(s1.equals(s2)); //true
    }

    public void test2(){
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";

        //如果拼接符号的前后出现了变更 ，则相当于在堆空间中new String(),具体的内容为拼接的结果：javaEEhadoop
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        //intern()：判断字符串常量池中是否存在javaEEhadoop值，如果存在，则返回常量池中javaEEhadoop的地址；
        //如果字符串常量池中不存在javaEEhadoop，则在常量池中加载一份javaEEhadoop，并返回此对象的地址。
        String s8 = s6.intern();
        System.out.println(s3 == s8);//true

    }

    public void test3(){
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        /**
         *如下的s1 + s2的执行细节：(变量s是我临时定义的)
         * 1) StringBuilder s = new StringBuilder();
         * 2) s.append("a")
         * 3) s.append("b")
         * 4) s.toString() --> 约等于new String("ab")
         * */
        String s4 = s1 + s2;
        System.out.println(s3 == s4);//false

    }

    /**
     * 1、字符串拼接操作不一定使用的是StringBuilder!
     * 如果拼接符号左右两边都是字符串常量或常量引用，则仍然使用编译期优化，即非StringBuilder的方式 。
     * 2、针对于final修饰类、方法、基本数据类型、引用数据类型的标识符(变量)的结构时，能使用上final的时候建议使用上。
     * */
    public void test4() {
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";

        String s4 = s1 + s2;
        System.out.println(s3 == s4);//true
    }

    //体会效率
    public void Test5(){
        long start = System.currentTimeMillis();
        method1(100000); //消耗时间 4470
        long end = System.currentTimeMillis();
        System.out.println("method1花费时间："+(end-start));

        start = System.currentTimeMillis();
        method2(100000); //消耗时间 3
        end = System.currentTimeMillis();
        System.out.println("method2花费时间："+(end-start));
    }

    private void method1(int highLevel) {
        String src = "";
        for (int i = 0; i < highLevel; i++) {
            src = src + "a";//每次循环都会创建一个StringBuilder、String
        }
    }
    private void method2(int highLevel) {
        //只要创建一个StringBuilder
        StringBuilder src = new StringBuilder();
        for (int i = 0; i < highLevel; i++) {
            src.append("a");
        }
    }
}
