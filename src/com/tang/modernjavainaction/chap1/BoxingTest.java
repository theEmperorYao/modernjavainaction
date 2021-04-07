package com.tang.modernjavainaction.chap1;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * @author tangyao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年04月04日 20:31:00
 */
public class BoxingTest {


    public static void main(String[] args) {
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        System.out.println("evenNumbers.test(1000) = " + evenNumbers.test(1000));


        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;
        System.out.println("oddNumbers.test(1000) = " + oddNumbers.test(1000));


    }

}
