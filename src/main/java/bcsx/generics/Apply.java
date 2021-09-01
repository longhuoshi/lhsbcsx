package bcsx.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static bcsx.net.mindview.util.Print.*;

/**
 * @author l
 * @date 2020/7/29 16:14
 * @description
 *
 * 15.17.2 将一个方法应用于序列
 *
 */


public class Apply {
    public static <T,S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args){
        try {
            for (T t : seq) {
                f.invoke(t,args);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Shape{
    public void rotate(){print(this + " rotate");}
    public void resize(int newSize){
        print(this +" resize "+ newSize);
    }
}

class Square extends Shape{}


class FilledList<T> extends ArrayList<T>{
    public FilledList(Class<? extends T> type,int size){

        try {
            for (int i = 0; i < size; i++)
                // Assumes default constructor:
                add(type.newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

class ApplyTest{
    public static void main(String[] args) throws Exception {
        List<Shape> shapes = new ArrayList<Shape>();
        for (int i = 0; i < 10; i++) {
            shapes.add(new Shape());
        }
        Apply.apply(shapes,Shape.class.getMethod("rotate"));
        print("------------------------------------------");
        Apply.apply(shapes,Shape.class.getMethod("resize",int.class),5);

        List<Square> squares = new ArrayList<Square>();
        for (int i = 0; i < 10; i++) {
            squares.add(new Square());
        }
        print("==========================================");
        Apply.apply(squares,Shape.class.getMethod("rotate"));
        print("------------------------------------------");
        Apply.apply(squares,Shape.class.getMethod("resize", int.class),5);

        print("==========================================2");
        Apply.apply(new FilledList<Shape>(Shape.class,10),Shape.class.getMethod("rotate"));
        print("------------------------------------------");
        Apply.apply(new FilledList<Shape>(Square.class,10),Shape.class.getMethod("rotate"));

        print("------------------------------------------");
        Apply.apply(new FilledList<Shape>(Shape.class,3),Shape.class.getMethod("resize",int.class),235234);


        print("----------------------myself--------------------");
        SimpleQueue aaa = new SimpleQueue<>();
        aaa.add(new Contract());
        Apply.apply( aaa ,Contract.class.getMethod("rotate"));



    }
}
