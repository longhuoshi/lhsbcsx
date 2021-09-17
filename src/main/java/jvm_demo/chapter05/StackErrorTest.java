package jvm_demo.chapter05;


/**
 * 演示栈中异常：StackOverflowError
 *
 * 默认情况下 count:10559
 * 设置栈的大小: -Xss256k
 * 菜单Run->Edit Configurations->Configuration->VM options 里添加 -Xss256k
 * count:2363
 *
 * */
public class StackErrorTest {
    private static int count = 1;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
