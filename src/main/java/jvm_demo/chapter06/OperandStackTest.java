package jvm_demo.chapter06;

/**
 *53-涉及操作数栈的字节码指令执行分析
 * */
public class OperandStackTest {
    public void testAddOperation(){
        //byte,short,char,boolean:都是以int型来保存的
        byte i = 15;
        int j = 8;
        int k = i +j ;

        //int m = 8;  //以bipush  压栈
        //int m = 800;  //以sipush   压栈
    }

    public int getSum(){
        int m = 10;
        int n = 20;
        int k = m+n ;
        return k;
    }
    public void testGetSum(){
        //获取上一个栈帧返回的结果，并保存在操作数栈中。
        int i = getSum();
        int j = 10;

    }

}
