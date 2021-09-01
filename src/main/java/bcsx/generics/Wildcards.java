package main.java.bcsx.generics;

/**
 * @author l
 * @date 2020/1/6 10:29
 * @description
 */
public class Wildcards {

    //Raw argument:
    static void rawArgs(Holder holder,Object arg){
        holder.set(arg); //warning
        //Unchecked call to 'set(T)' as a member of raw type 'Holder'
        holder.set(new Wildcards());//Sane warning

        //Can't do this ;don't have any 'T';
//        T t = holder.get();


        //Ok, but type information has been lost:
        Object obj = holder.get();

    }

    //Similar to rawArgs() ,but errors instead of warnings:
    static void unboundedArg(Holder<?> holder,Object arg){
//        holder.set(arg);//error
        //'set(capture<?>)' in 'Holder' cannot be applied to '(Object)'
//        holder.set(new Wildcards());//Same error

        //Can't do this ;don't have any 'T';
//        T t = holder.get();

        //Ok,but type information has been lost:
        Object obj = holder.get();

    }

    static <T> T exact1(Holder<T> holder){
        T t = holder.get();
        return t;
    }
    static <T> T exact2(Holder<T> holder,T arg){
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> T wildSubtype(Holder<? extends T> holder,T arg){
//        holder.set(arg);// Error:
        //'set(capture<? extends T>)' in 'Holder' cannot be applied to '(T)'
        T t = holder.get();
        return  t;


    }

    static <T> void wildSupertype(Holder<? super T> holder,T arg){
        holder.set(arg);
//        T t = holder.get(); //Error:
        //Incompatible types. Found: 'capture<? super T>', required: 'T'

        //Ok,but type information has been lost:
        Object obj = holder.get();

    }


    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        //Or:
        raw = new Holder();
        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbouded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();
        Long lng = 1L;

        rawArgs(raw,lng);
        rawArgs(qualified,lng);
        rawArgs(unbouded,lng);
        rawArgs(bounded,lng);

        unboundedArg(raw,lng);
        unboundedArg(qualified,lng);
        unboundedArg(unbouded,lng);
        unboundedArg(bounded,lng);

        Object  r1 = exact1(raw);
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbouded);
        Long r4 = exact1(bounded);

        Long r5 = exact2(raw,lng);//Warnings
        //Unchecked assignment: 'Holder' to 'Holder<Long>'
        Long r6 = exact2(qualified,lng);
//        Long r7 = exact2(unbouded,lng);//Error:
        //'exact2(Holder<T>, T)' in 'Wildcards' cannot be applied to '(Holder<capture<?>>, java.lang.Long)'
//        Long r8 = exact2(bounded,lng);//Error
        //'exact2(Holder<T>, T)' in 'Wildcards' cannot be applied to '(Holder<capture<? extends Long>>, .Long)'


        Long r9 = wildSubtype(raw,lng);//Warnings
        //Unchecked assignment: 'Holder' to 'Holder<? extends Long>'
        Long r10 = wildSubtype(qualified,lng);
        //Ok,but can only return Object:
        Object r11 = wildSubtype(unbouded,lng);
        Long r12 = wildSubtype(bounded,lng);

        wildSupertype(raw,lng);//Warnings
        //Unchecked assignment: 'main.java.bcsx.main.java.generics.Holder' to 'main.java.bcsx.main.java.generics.Holder<? super java.lang.Long>'
        wildSupertype(qualified,lng);
//        wildSupertype(unbouded,lng);//Error
        //'wildSupertype(Holder<? super T>, T)' in 'Wildcards' cannot be applied to '(Holder<capture<?>>, Long)'
//        wildSupertype(bounded,lng);//Error
//        'wildSupertype(Holder<? super T>, T)' in 'Wildcards' cannot be applied to '(Holder<capture<? extends Long>>, Long)'


    }
}
