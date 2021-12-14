package m_thread.third.jucadvance.tl;

/**
 * @author l
 * @date 2021/12/7 11:43
 * @description
 *
 *
 */

//老方法，所有线程共享资源
class MovieTicket{
    int number = 30;
    public synchronized void saleTicket(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName()+"----卖出"+ (number--));
        }else
            System.out.println(Thread.currentThread().getName()+"----卖光了");
    }
}

//各凭销售本事提成 ，按照出单数各自统计 。
//每个线程都有自己的 变量副本。
class HouseSale{
//    ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
//        @Override
//        protected Integer initialValue() {
//            return 0;
//        }
//    };
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
    public void saleHouse(){
        Integer integer = threadLocal.get();
        integer++;
        threadLocal.set(integer);
    }
}

public class ThreadLocalDemo {
    public static void main(String[] args) {
//        testMovieTicket();

        HouseSale house = new HouseSale();
        new Thread(()->{
            try{
                for (int i = 0; i < 5; i++) {
                    house.saleHouse();
                }
                System.out.println(Thread.currentThread().getName()+"---卖出："+house.threadLocal.get());
            }finally {
                //一定要释放 本线程自己的变量副本。 。
                house.threadLocal.remove();
            }

        },"t1").start();

        new Thread(()->{
            try {
                for (int i = 0; i < 13; i++) {
                    house.saleHouse();
                }
                System.out.println(Thread.currentThread().getName()+"---卖出："+house.threadLocal.get());
            }finally {
                house.threadLocal.remove();
            }
        },"t2").start();

        try {
            System.out.println(Thread.currentThread().getName()+"---卖出："+house.threadLocal.get());
        }finally {
            house.threadLocal.remove();
        }
    }

    private static void testMovieTicket() {
        MovieTicket movieTicket = new MovieTicket();
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                for (int j = 0; j < 20; j++) {
                    movieTicket.saleTicket();
                }
            },String.valueOf(i)).start();
        }
    }


}
