package no996.chap1;

/**
 * @author l
 * @date 2020/9/24 11:42
 * @description
 * 【No996】2020年最新 Java多线程编程核心基础
 */
public class Demo01 {
    public static void main(String[] args) throws InterruptedException {
        while (true){
            System.out.println(System.currentTimeMillis());
            Thread.sleep(1000);
        }
    }
}

