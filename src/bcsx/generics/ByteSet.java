package bcsx.generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author l
 * @date 2020/6/17 15:31
 * @description
 */
public class ByteSet {
    Byte[] possibles = {1,2,3,4,5,6,7,8,9};
    Set<Byte> mySet = new HashSet<Byte>(Arrays.asList(possibles));
    //But you can't do this :
//    Set<Byte> mySet2 = new HashSet<Byte>(Arrays.<Byte>asList(1,2,3,4,5,6,7,8,9));
}
