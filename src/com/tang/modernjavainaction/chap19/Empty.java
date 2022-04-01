package com.tang.modernjavainaction.chap19;


import lombok.Data;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Title: MyLinkedList
 * @Description:
 * @author: tangyao
 * @date: 2022/3/30 17:07
 * @Version: 1.0
 */

interface MyList<T> {
    T head();

    MyList<T> tail();

    default boolean isEmpty() {
        return true;
    }

    default MyList<T> filter(Predicate<T> p) {
        return isEmpty() ? this :
                p.test(head()) ?
                        new LazyList<T>(head(), () -> tail().filter(p)) : tail().filter(p);
    }

    static <T> void printAll(MyList<T> list) {
        if (list.isEmpty()) {
            return;
        }
        System.out.println(list.head());
        printAll(list.tail());
    }


}

public class Empty<T> implements MyList<T> {
    @Override
    public T head() {
        throw new UnsupportedOperationException();
    }


    @Override
    public MyList<T> tail() {
        return (MyList<T>) new UnsupportedOperationException();
    }
}

class LazyList<T> implements MyList<T> {

    final T head;
    final Supplier<MyList<T>> tail;

    public LazyList(T head, Supplier<MyList<T>> tail) {
        this.head = head;
        this.tail = tail;
    }


    @Override
    public T head() {
        return head;
    }

    @Override
    public MyList<T> tail() {
        return tail.get();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public static LazyList<Integer> from(int n) {
        return new LazyList<Integer>(n, () -> from(n + 1));
    }


}


@Data
class MyLinkedList<T> implements MyList<T> {

    private final T head;
    private final MyList<T> tail;

    MyLinkedList(T head, MyList<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    @Override
    public T head() {
        return head;
    }

    @Override
    public MyList<T> tail() {
        return tail;
    }


}