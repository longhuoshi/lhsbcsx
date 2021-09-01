package reflex;

/**
 * @author l
 * @date 2021/9/1 17:24
 * @description

 *1.定义发送短信的接口
 */
public interface SmsService {
    String send(String message);
}
