package bcsx.generics;

import bcsx.typeinfo.Person;

/**
 * @author l
 * @date 2020/6/19 17:13
 * @description
 * {CompileTimeError} (Won't compile)
 * HijackedInterface
 *15.11.5 基类劫持了接口
 */

//Error:'Comparable' cannot be inherited with different type arguments: 'ComparablePet' and 'Cat'
//class Cat extends ComparablePet implements Comparable<Cat> {
class Cat implements Comparable<Cat> {

    @Override
    public int compareTo(Cat arg) {
        return 0;
    }
}
