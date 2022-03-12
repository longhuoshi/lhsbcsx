package jvm_demo.chapter13;

import java.util.HashSet;
import java.util.Set;
/**
 * jdk8中
 * -XX:MetaspaceSize=6m -XX:MaxMetaspaceSize=6m -Xms6m -Xmx6m
 * */
public class StringTest3 {
    public static void main(String[] args) {
        //使用Set保持着常量 池引用 ，避免full gc回收常量 池行为。
        Set<String> set = new HashSet<>();
        //在short可以取值的范围内足以让6MB的PermSize或heap产生OOM了。
        short i = 0;
        while (true){
            set.add(String.valueOf(i++).intern());
        }
    }
}
