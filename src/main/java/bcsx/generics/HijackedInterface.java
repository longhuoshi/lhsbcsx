package bcsx.generics;

import bcsx.typeinfo.Person;

/**
 * @author l
 * @date 2020/6/19 17:13
 * @description
 * {CompileTimeError} (Won't compile)
 * HijackedInterface
 *15.11.5 基类劫持了接口
 *
 * previous {@link ComparablePet}
 * next {@link Hamster  }
 *
 */

//Error:'Comparable' cannot be inherited with different type arguments: 'ComparablePet' and 'Cat'
//这不能工作，一旦为Comparable确定了ComparablePet参数，那么其他任何实现类都不能与ComparablePet之外的任何对象比较。
//class Cat extends ComparablePet implements Comparable<Cat> {
class Cat implements Comparable<Cat> {

    @Override
    public int compareTo(Cat arg) {
        return 0;
    }
}
