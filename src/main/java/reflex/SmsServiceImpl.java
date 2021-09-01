package reflex;

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
}
