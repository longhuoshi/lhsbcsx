package main.java.generics.plate;

import java.util.List;

/**
 * @author l
 * @date 2021/4/25 16:20
 * @description
 */
public class Plate<T> {
    private T item;

    public Plate(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Plate<? extends T> getPlate(Plate<? super T> p){

        return (Plate<? extends T>)p;
    }





}
