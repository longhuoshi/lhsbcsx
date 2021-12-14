package m_thread.third.jucadvance.tl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author l
 * @date 2021/12/7 14:51
 * @description
 *
 */
public class ThreadLocalDateUtils {
    //错误的，会有并发问题
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static Date parse(String strDate) throws ParseException {
        return sdf.parse(strDate);
    }

    //正确的
    public static final ThreadLocal<SimpleDateFormat> sdfThreadLocal = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    public static final Date parseByThreadLocal(String strDate) throws ParseException {
        return sdfThreadLocal.get().parse(strDate);
    }



    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
//                    System.out.println(parse("2021-12-07 14:55:11"));
                    System.out.println(parseByThreadLocal("2021-12-07 14:55:11"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }finally {
                    sdfThreadLocal.remove();
                }

            }).start();

        }
    }
}
