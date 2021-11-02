package myjava.java8.optional;

import java.util.Optional;

/**
 * @author l
 * @date 2021/11/1 14:43
 * @description
 *周颖和七仙女（费沁雯、吴梦瑶、何洁、路灿洋、凯琳、杨柳青、白灵路）
 */
public class OptionalTest {
    public static void main(String[] args) {
//        test1();
        test2();

    }


    /**
     * Optional<T> of(T value) 创建一个Optional实例，t必须非空。
     * Optional.empty()  创建一个空的Optional实例
     * Optional.ofNullable(T value) t可以为null
     *
     * */
    public static void test1(){
        Girl girl = new Girl();
//        girl = null;
        Optional<Girl> girl1 = Optional.of(girl);
        System.out.println(girl1);

        girl=null;
        Optional<Girl> girl2 = Optional.ofNullable(girl);
        System.out.println(girl2);

        Girl girl3 = girl2.orElse(new Girl("费沁雯"));
        System.out.println(girl3);

    }

    // ***********Optional日常写代码的应用。 ***********
    public static String getGirlName(Boy boy){
        String name = boy.getGirl().getName();
        return name;
    }


    //加判断后
    public static String getGirlName2(Boy boy){
        if (boy!=null){
            Girl girl = boy.getGirl();
            if (girl!=null)
                return girl.getName();
        }
        return  null;
    }
    //用Optional优化后。
    public static String getGirlName3(Boy boy){
        Optional<Boy> boy1 = Optional.ofNullable(boy);
        Boy boy2 = boy1.orElse(new Boy());
        Girl girl = boy2.getGirl();

        Girl girl1 = Optional.ofNullable(girl).orElse(new Girl("迪丽热巴"));

        return  girl1.getName();
    }


    public static void test2(){
        Boy boy = new Boy();
//        String girlName = getGirlName(boy);
//        String girlName = getGirlName2(null);
        String girlName = getGirlName3(null);

        System.out.println(girlName);

    }



}
