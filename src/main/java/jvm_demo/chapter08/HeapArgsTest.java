package jvm_demo.chapter08;

/**
 * 测试堆空间常用的jvm参数
 *
 *  -XX:+PrintFlagsInitial   //查看所有的参数的默认初始值
 * -XX:+PrintFlagsFinal		 //查看所有的参数的最终值(可能会存在修改，不再是初始值)
 *      查看单个参数值的指令：1)jps:查看当前运行中的进程 2) jinfo -flags 参数名 进行id
 *
 * -Xms						//初始堆空间内存	(默认为物理内存的1/64)
 * -Xmx						//最大堆空间内存	(默认的物理内存的1/4)
 * -Xmn						//设置新生代的大小。(初始值及最大值)
 * -XX:NewRatio		//配置新生代与老年代在堆结构的占比
 *
 * -XX:SurvivorRatio	//设置新生代中Eden和s0/s1空间的比例
 *      示例：-XX:SurvivorRatio=5
 * -XX:MaxTenuringThreshold //设置新生代垃圾的最大年龄。
 * -XX:+PrintGCDetails //输出详细GC处理日志
 * 		打印g 简要信息：1) -XX:PrintGC	2) -verbose:gc
 * -XX:HandlePromotionFailure //是否设置空间分配担保。
 *
 * */
public class HeapArgsTest {

    public static void main(String[] args) {

    }

}
