package myjava.lambda;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author l
 * @date 2021/7/8 11:19
 * @description
 *
 * 如何使用Stream流？
 *
 */
public class StreamDemo {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int sum = IntStream.of(nums).sum();
        int sum2 = IntStream.of(nums).parallel().sum();
        System.out.println(sum);
        System.out.println(sum2);


        //Stream上的操作并不会立即执行，只有等到用户真正需要结果的时候才会执行（惰性求值)
        //比如说，peek()是一个中间操作，返回的是Stream流对象，只要它不执行最终的操作，这个Stream是不会执行的。
        String str = "my name is 007";
//        Stream.of(str.split(" ")).peek(System.out::println); // 不会有信息打印
        Stream.of(str.split(" ")).peek(System.out::println).forEach(System.out::println);
        // 至于中间操作和最终操作怎么区分，我们以返回值来看就行了。中间操作返回的是Stream实例对象，最终操作返回的不是Stream实例对象：
    }
}
