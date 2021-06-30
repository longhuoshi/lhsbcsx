package bcsx.generics;

import bcsx.net.mindview.util.CountingGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author l
 * @date 2019/12/23 17:09
 * @description
 *
 * 15.10.3 无界通配符
 * previous {@link UnboundedWildcards1}
 * next {@link Wildcards}
 *
 * 展示了无界通配符的一个重要应用。当你在处理多个泛型参数时，有时允许一个参数 可以是任何类型，
 * 同时为其他参数确定某种特定类型的这种能力会显得很重要。
 *
 * List实际上就是List<Object>
 * List表示“持有任何Object类型的原生List”
 * List<?>表示“具有某种特定类型的非原生List”，只是我们不知道那种类型是什么。
 */
public class UnboundedWildcards2 {
    static Map map1;
    static Map<?,?> map2;
    static Map<String,?> map3;
    static void assign1(Map map) { map1 = map; }
    static void assign2(Map<?,?> map) { map2 = map; }
    static void assign3(Map<String,?> map) { map3 = map; }

    public static void main(String[] args) {
        assign1(new HashMap());
        assign2(new HashMap());
        assign3(new HashMap()); //Warning:
        //unchecked Conversion Found : HashMap
        //Required:Map<String,? >

        assign1(new HashMap<String,Integer>());
        assign2(new HashMap<String,Integer>());
        assign3(new HashMap<String,Integer>());



    }
}
