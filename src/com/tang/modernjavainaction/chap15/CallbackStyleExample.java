package com.tang.modernjavainaction.chap15;


import java.util.function.Consumer;

/**
 * @Title: CallbackStyleExample
 * @Description:
 * @author: tangyao
 * @date: 2022/3/23 18:22
 * @Version: 1.0
 */


class Result {
    int left;
    int right;
}

public class CallbackStyleExample {

    public static void main(String[] args) {

        Result result = new Result();
        int x = 1337;
        f(x, (Integer y) -> {
            result.left = y;
            System.out.println((result.left + result.right));
        });

        g(x, (Integer z) -> {
            result.left = z;
            System.out.println((result.left + result.right));
        });


    }

    private static void g(int x, Consumer<Integer> c) {
        c.accept(x);
        c.accept(x);
        c.accept(x);
    }

    private static void f(int x, Consumer<Integer> c) {
        c.accept(x);
    }
}