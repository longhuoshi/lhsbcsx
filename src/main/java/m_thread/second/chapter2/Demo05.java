package m_thread.second.chapter2;

import generics.Demo;

/**
 * @author l
 * @date 2021/9/7 11:01
 * @description
 *
 * 18.线程的同步机制-synchronized同步方法-脏读
 *synchronized用的是对象锁，同一个对象上加了synchronized的方法。是排队执行的，
 * 不管多少个线程执行，都要等拿 到锁的线程 把一个方法执行完，下个拿到锁的线程才能执行下一个方法。
 */
public class Demo05 {
    public static void main(String[] args) throws InterruptedException {
        Demo05User user = new Demo05User();
        Thread t = new Demo05Thread(user);
        t.start();
        Thread.sleep(200);
        user.getValue();

    }
}
class Demo05User{
    private String username = "a";
    private String password = "b";

    synchronized public void setUsernameAndPassword(String username,String password){
        this.username = username;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;
        System.out.println("setUsernameAndPassword方法，线程名称："+Thread.currentThread().getName()
                +",username="+this.username+",password="+this.password);

    }

     public void getValue(){
        System.out.println("getValue方法，线程名称："+Thread.currentThread().getName()
                +",username="+username+",password="+password);

    }
}

class Demo05Thread extends Thread{
    private Demo05User user;
    public Demo05Thread(Demo05User user){
        this.user = user;
    }
    public void run(){
        user.setUsernameAndPassword("C","CB");
    }
}

