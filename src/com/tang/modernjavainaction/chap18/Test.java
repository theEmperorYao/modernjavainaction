package com.tang.modernjavainaction.chap18;


import java.util.*;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.LongStream;

/**
 * @Title: Test
 * @Description:
 * @author: tangyao
 * @date: 2022/3/30 10:20
 * @Version: 1.0
 */

public class Test {

    public static void main(String[] args) {

        List<List<Integer>> list = subSets(Arrays.asList(1, 4, 9, 23, 3451, 15));
        System.out.println("list = " + list.size());

        long start = System.nanoTime();
//
//        long l1 = factorialRecursive(10_000);
        long l1 = factorialTailRecursive(10_000);
        System.out.println("l1 = " + l1);
//
//        System.out.println((System.nanoTime() - start) / 1_000_000 + " msecs");

//        start = System.nanoTime();
//        long l = factorialIterative(100000000);
//        System.out.println("l = " + l);
        System.out.println((System.nanoTime() - start) / 1_000_000 + " msecs");

        start = System.nanoTime();
        long l2 = factorialStreams(100000000);
        System.out.println("l2 = " + l2);
        System.out.println((System.nanoTime() - start) / 1_000_000 + " msecs");

        long l = factorialTailRecursive(3);
        System.out.println("l = " + l);

        DoubleUnaryOperator doubleUnaryOperator = curriedConverter(10, 2.0);
        doubleUnaryOperator.applyAsDouble(10);



    }

    static List<List<Integer>> subSets(List<Integer> list) {
        if (list.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }
        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());
        List<List<Integer>> subans = subSets(rest);
        List<List<Integer>> subans2 = insertAll(first, subans);
        return concat(subans, subans2);


    }

    private static List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }

        return result;
    }

    static List<List<Integer>> concat(List<List<Integer>> a, List<List<Integer>> b) {
        List<List<Integer>> r = new ArrayList<>(a);
        r.addAll(b);
        return r;
    }

    static long factorialIterative(long n) {
        long r = 1;
        for (int i = 1; i <= n; i++) {
            r += i;
        }
        return r;
    }

    static long factorialRecursive(long n) {
        return n == 1 ? 1 : n + factorialRecursive(n - 1);
    }

    static long factorialStreams(long n) {
        return LongStream.rangeClosed(1, n).reduce(1, Long::sum);
    }

    static long factorialTailRecursive(long n) {
        return factorialHelper(1, n);
    }

    private static long factorialHelper(long acc, long n) {

        return n == 1 ? acc : factorialHelper(acc + n, n - 1);
    }

    static DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> x * f + b;
    }


}