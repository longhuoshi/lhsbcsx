package reflex;

/**
 * @author l
 * @date 2021/9/1 17:34
 * @description
 * 5.实际使用
 *
 */
public class Test {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("hello 赵薇");

    }
}
