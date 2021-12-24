package m_thread.intermediate;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author l
 * @date 2021/4/30 16:50
 * @description
 *
 * 5.5 延时队列DelayQueue
 *
 */

//实现一个Student对象作为DelayQueue的元素必须实现Delayed接口的两个方法
 class Student implements Delayed{
     private String name;
     private long submitTime;  //交卷时间
    private long workTime; //考试时间
    public String getName(){
        return this.name +" 交卷，用时 "+workTime;
    }
    public Student(String name ,long submitTime){
        this.name = name;
        this.workTime = submitTime;
        this.submitTime = TimeUnit.NANOSECONDS.convert(submitTime,TimeUnit.MILLISECONDS)+System.nanoTime();
        System.out.println(this.name +" 交卷，用时 "+workTime);
    }

    /**
     * Returns the remaining delay associated with this object, in the
     * given time unit.
     *
     * @param unit the time unit
     * @return the remaining delay; zero or negative values indicate
     * that the delay has already elapsed
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(submitTime-System.nanoTime(),unit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        Student that = (Student)o;
        return submitTime>that.submitTime ? 1 :(submitTime < that.submitTime ? -1 : 0);
    }
}

public class DelayQueueTest {
    public static void main(String[] args) throws Exception{
        //新建等待队列
        final DelayQueue<Student> bq = new DelayQueue<Student>();
        for (int i = 0; i < 5; i++) {
            Student student = new Student("学生"+i,Math.round(Math.random()*10+1));
            bq.put(student);

        }
        //获取但不移除此队列的头部，如果 此队列为空，则返回null.
        System.out.println("bq.peek():"+bq.peek().getName());

        //获取并移除此队列的头部，在可从此队列获得到期延迟的元素，或者
        //到达指定的等待时间之前一直等待（如有必要）。
//            bq.poll()  //有空可以试试这个方法

        System.out.println("bq.poll():"+bq.poll(3,TimeUnit.SECONDS).getName());
    }
}
