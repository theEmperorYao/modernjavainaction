package com.tang.modernjavainaction.forkjoin;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Title: FutureTaskTest
 * @Description:
 * @author: tangyao
 * @date: 2022/3/18 11:47
 * @Version: 1.0
 */

public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();

        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(100);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 100, 1, TimeUnit.MILLISECONDS, workQueue);

        Future<Integer> submit = threadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(10000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });

        Future<Integer> submit2 = threadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2;
        });


        Integer integer1 = submit2.get();
        System.out.println("integer1 = " + integer1);

        Integer integer = submit.get();
        System.out.println("integer = " + integer);



    }
}