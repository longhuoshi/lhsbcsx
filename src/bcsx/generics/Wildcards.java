package bcsx.generics;

/**
 * @author l
 * @date 2020/1/6 10:29
 * @description
 *
 * List和List<Object> 实际上表示 “持有任何object类型的原生List”
 * List<?>  实际上表示 “持有某种特定类型的非原生List”,只是我们不知道那种类型是什么。
 *
 * 在wildSubtype()中，在Holder类型上的限制被放松为包括持有任何扩展自T的对象的Holder。
 * 这还是意味着如果T是Fruit,那么holder可以是Holder<Apple>,这是合法的。为了防止将
 * Orange放置到Holder<Apple>中，对set()的调用 (或者对任何接受这个类型参数为参数的方法的
 * 调用)都是不允许的。但是，你仍旧知道任何来自Holder<? extends Fruit>的对象至少是Fruit,
 * 因此get() (或者任何将产生具有这个类型参数的返回值的方法)。都是允许的。
 *
 * wildSupertype()展示了超类型通配符，这个方法展示了与wildSubtype()相反的行为：holder
 * 可以是持有任何T的基类型（父类型）的容器。因此，set()可以接受T，因为任何可以工作于基类的对象都
 * 可以多态地作用于导出类（这里就是T）。但是，尝试着调用get是没有用的。因为由holder持
 * 有的类型可以是任何超类型，因此唯一安全的类型就是object。
 *
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
        //Unchecked assignment: 'bcsx.generics.Holder' to 'bcsx.generics.Holder<? super java.lang.Long>'
        wildSupertype(qualified,lng);

//        wildSupertype(unbouded,lng);//Error
        //'wildSupertype(Holder<? super T>, T)' in 'Wildcards' cannot be applied to '(Holder<capture<?>>, Long)'
//        wildSupertype(bounded,lng);//Error
//        'wildSupertype(Holder<? super T>, T)' in 'Wildcards' cannot be applied to '(Holder<capture<? extends Long>>, Long)'


    }
}
