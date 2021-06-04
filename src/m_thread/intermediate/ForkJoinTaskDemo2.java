package m_thread.intermediate;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author l
 * @date 2021/5/12 17:03
 * @description
 *
 * 7.6 Fork/Join 模式优缺点及其实际应用场景 。
 * 对一个静态资源服务器的图片文件目录树进行遍历和分析的时候，需要递归地统计每个目录下的文件数量 ，最后汇总。
 *
 */
public class ForkJoinTaskDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Thread Main begin!");
        Integer count = new ForkJoinPool().invoke(new CountingTask(Paths.get("E:\\Download\\ed"))); //  整个磁盘统计 E:\
        System.out.println("总文件数量："+count);
        System.out.println("Thread Main End!");
    }


}

//处理单个目录 的任务
class CountingTask extends RecursiveTask<Integer>{
    private String grandfather= "E:";
    private Path dir;


    public CountingTask(Path dir){
        this.dir = dir;
    }

    @Override
    protected Integer compute() {
        int count = 0;
        List<CountingTask> subTasks = new ArrayList<>();
        //读取目录dir的子路径
        try {
            DirectoryStream<Path> ds = Files.newDirectoryStream(dir);
            for (Path subPath : ds){
                if (Files.isDirectory(subPath, LinkOption.NOFOLLOW_LINKS)){
                    //对每个子目录 都新建一个子任务。
                    subTasks.add(new CountingTask(subPath));
                }else{
                    //遇到文件，则计数器增加1
                    count++;

                    //得到文件路径
                    if (subPath.getParent().getParent().getFileName()!=null){
                        grandfather = subPath.getParent().getParent().getFileName().toString();
                    }
                    System.out.println("FileName:"+grandfather+"/"+subPath.getParent().getFileName()+"/"+subPath.getFileName());

                }
            }
            if (!subTasks.isEmpty()){
                //在当前的ForkJoinPool上调度所有的子任务。
                for (CountingTask subTask : invokeAll(subTasks)){
                    count += subTask.join();
                }
            }
        } catch (IOException e) {
            return 0;
//            e.printStackTrace();

        }
        return count;
    }
}