package com.tang.modernjavainaction.chap19;

import org.springframework.context.annotation.Lazy;

import java.util.function.Predicate;

import static com.tang.demo.chap19.LazyList.*;
import static com.tang.demo.chap19.MyList.*;

/**
 * @Title: EmptyTest
 * @Description:
 * @author: tangyao
 * @date: 2022/3/30 17:14
 * @Version: 1.0
 */

public class EmptyTest {
    public static void main(String[] args) {
        MyList<Integer> l = new MyLinkedList<>(5, new MyLinkedList<>(10, new Empty<>()));

        LazyList<Integer> numbers = from(2);
//        int two = primes(numbers).head();
//        int three = primes(numbers).tail().head();
//        int four = primes(numbers).tail().tail().head();
//        int five = primes(numbers).tail().tail().tail().head();
//        System.out.println(two + " " + three + " " + four + " " + five);

        printAll(primes(numbers));

    }


    public static MyList<Integer> primes(MyList<Integer> numbers) {
        return new LazyList<>(numbers.head(),
                () -> primes(
                        numbers.tail().filter(n -> n % numbers.head() != 0)
                ));
    }


}