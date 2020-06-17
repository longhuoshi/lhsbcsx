package bcsx.generics;

import bcsx.net.mindview.util.CountingGenerator;

/**
 * @author l
 * @date 2020/6/16 17:02
 * @description
 *15.10.4 捕获转换
 *
 */
public class CaptureConversion {
    static <T> void f1(Holder<T> holder){
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }


    /**
     * 这里所发生的是：参数类型在调用f2()的过程中被捕获，因此它可以在对f1()的调用中被使用。
     *
     * */
    static void f2(Holder<?> holder){
        f1(holder); // Call with captured type
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);
        f1(raw); //produces warnings
        f2(raw); //No warnings

        Holder rawBasic = new Holder();
        rawBasic.set(new Object()); //warning
        f2(rawBasic); //No warning
        // Upcast to Holder<?>, still figures it out:
        Holder<?> wildcarded = new Holder<Double>(1.0);
        f2(wildcarded);




    }

}
