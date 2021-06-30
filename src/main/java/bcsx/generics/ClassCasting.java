package bcsx.generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author l
 * @date 2020/6/18 17:35
 * @description
 */
public class ClassCasting {
    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
//        List<Widget> lw1 = List<Widget>.class.cast(in.readObject());
        List<Widget> lw2 = List.class.cast(in.readObject());

    }


}
