package jvm_demo.chapter13;

/**
 * 面试题 1
 * 题目：new String("ab") 会创建几个对象？
 * 看字节码就知道是两个。
 * 对象1堆空间不是常量池区域  new 关键字在堆空间创建的 (对应字节码： new #2 <java/lang/String>)
 * 对象2存在堆空间常量池区域 "ab"  (对应字节码： ldc #3 <ab>)
 *
 * 拓展：new String("a") + new String("b") 呢？
 * 只要有拼接操作"+" 就会用到StringzBuilder
 * 对象1:new StringzBuilder() (对应字节码： new #2 <java/lang/StringzBuilder> )
 * 对象2: new String("a") (对应字节码： new #4 <java/lang/String> )
 * 对象3: 常量池中的"a" (对应字节码： ldc #5 <a>)
 * 对象4:  new String("b") ((对应字节码： new #4 <java/lang/String>)
 * 对象5: 常量池中的"b" (对应字节码： ldc #8 <b>)
 *
 * 深入剖析：StringBuilder的toString()：
 * 对象6：new String("ab") (对应字节码： new #80 <java/lang/String> )
 *  强调一下，toString()的调用，在字符串常量池中，没有生成"ab"
 *
 * */


public class StringNewTest {
    public static void main(String[] args) {
        String str = new String("ab");

        String str2 = new String("a") + new String("b");
    }
}
