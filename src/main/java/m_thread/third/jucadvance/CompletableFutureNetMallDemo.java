package m_thread.third.jucadvance;

import bcsx.containers.Prediction;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author l
 * @date 2021/10/26 10:50
 * @description
 *09_大厂真实案例比价需求
 *
 *案例说明：电商比价需求
 * 1、同一款产品，同时搜索出同款产品在各大电商的售价。
 * 2、同一款产品，同时搜索出本产品在某一个电商平台下，各个入驻门店的售价是多少。
 *
 * 出来结果希望是同款产品的在不同地方的价格清单列表 ，返回一个list
 * mysql in jd price is 109.80
 * mysql in pdd price is 109.74
 * mysql in taobao price is 110.47
 *
 * 3、要求深刻理解
 * 3.1 函数式编程
 * 3.2 链式编程
 * 3.3 stream流式计算
 *
 */
public class CompletableFutureNetMallDemo {
    static List<NetMall>  list = Arrays.asList(
        new NetMall("jd"),
        new NetMall("pdd"),
        new NetMall("taobao"),
        new NetMall("dangdangwang"),
        new NetMall("tmall")
    );

    public static List<String> getPriceByStep(List<NetMall> list , String productName){
        return list.stream().
                map(netMall -> String.format(productName + " in %s price is %.2f", netMall.getMallName(), netMall.calcPrice(productName)))
                .collect(Collectors.toList());
    }

    public static List<String> getPriceByAsync(List<NetMall> list , String productName){
        return list.stream().map(netMall -> CompletableFuture.supplyAsync(() -> String.format(productName + " in %s price is %.2f", netMall.getMallName(), netMall.calcPrice(productName))))
                .collect(Collectors.toList())
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        //a->a.join() == CompletableFuture::join
        //jdk8中使用了::的用法。就是把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下

    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<String> list1 =  getPriceByStep(list,"mysql");
        for (String element : list1) {
            System.out.println(element);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("---costTime:"+(endTime-startTime)+"毫秒");

        long startTime2 = System.currentTimeMillis();
        List<String> list2 =  getPriceByAsync(list,"mysql");
        for (String element : list2) {
            System.out.println(element);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("---costTime:"+(endTime2-startTime2)+"毫秒");
    }

}


class NetMall{
    private String mallName;

    public String getMallName() {
        return mallName;
    }

    public NetMall(String mallName) {
        this.mallName = mallName;
    }
    public double calcPrice(String productName){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble()*2 + productName.charAt(0);
    }
}
