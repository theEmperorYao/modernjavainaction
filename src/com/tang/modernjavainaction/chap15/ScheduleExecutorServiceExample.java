package com.tang.modernjavainaction.chap15;


import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * @Title: ScheduleExecutorServiceExample
 * @Description:
 * @author: tangyao
 * @date: 2022/3/23 18:37
 * @Version: 1.0
 */

public class ScheduleExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//
//        work1();
//        scheduledExecutorService.schedule(
//                ScheduleExecutorServiceExample::work2,
//                10,
//                TimeUnit.SECONDS);
//        scheduledExecutorService.shutdown();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        int x = 1;
        int t = p(x);
        int r = r(q1(t), q2(t));
        System.out.println("r = " + r);

        Future<Integer> a1 = executorService.submit(() -> q1(t));
        Future<Integer> a2 = executorService.submit(() -> q2(t));
        int r1 = r(a1.get(), a2.get());
        System.out.println("r1 = " + r1);

        CompletableFuture<Integer> a = new CompletableFuture<>();
        executorService.submit(() -> a.complete(q1(t)));
        int b = q2(t);
        System.out.println(a.get() + b);


        CompletableFuture<Integer> b2 = new CompletableFuture<>();
        CompletableFuture<Integer> c2 = a.thenCombine(b2, Integer::sum);

        executorService.submit(() -> a.complete(q1(t)));
        executorService.submit(() -> b2.complete(q2(t)));
        System.out.println(c2.get());


        executorService.shutdown();

    }

    static int r(int x, int y) {
        return x + y;
    }

    static int p(int x) {
        return x + 2;
    }


    static int q1(int t) {
        return t * 2;
    }

    static int q2(int t) {
        return t + 1;
    }


    private static void work2() {
        System.out.println("Hello from work2!");
    }

    private static void work1() {
        System.out.println("Hello from work1!");
    }


    static void f(int x, Flow.Subscriber<Integer> s) {

    }

    static void f(int x, Consumer<Integer> delWithResult, Consumer<Throwable> dealWithException) {

        try {

        } catch (Throwable e) {
            dealWithException.accept(e);
        }

    }


}