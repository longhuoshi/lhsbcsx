package bcsx.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author l
 * @date 2020/6/18 17:19
 * @description
 */
public class NeedCasting {
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
        //你会被强制要求转型，但又被告知不应该转型。为了解决这个问题，必须 使用java SE5中引入
        //  新的转型形式，退通过泛型类来转型 。
        List<Widget> shapes = (List<Widget>) in.readObject();


    }
}
