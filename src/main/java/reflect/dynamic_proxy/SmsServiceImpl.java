package reflect.dynamic_proxy;

/**
 * @author l
 * @date 2021/9/1 17:25
 * @description
 * 2.实现发送短信的接口
 *
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }

    @Override
    public void select(int id) {
        System.out.println("订单号是"+id);
    }
}
