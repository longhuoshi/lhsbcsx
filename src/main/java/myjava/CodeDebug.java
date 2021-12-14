package myjava;

/**
 * @author l
 * @date 2021/12/14 10:00
 * @description
 *
 * assert 断言功能
 * 默认情况下，JVM是关闭断言的。增加参数-enableassertions或者-ea打开断言
 */
public class CodeDebug {
    public static void main(String[] args) {
/*        boolean isSafe = false;
        assert isSafe : "Not safe at all";
        System.out.println("断言通过");*/

        join("bb-","ads");

    }
    private static String join(String x,String y){
        assert null != x;
        assert null != y;
        return  x+y;
    }
}
