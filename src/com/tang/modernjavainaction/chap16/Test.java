package com.tang.modernjavainaction.chap16;


import java.util.*;
import java.util.concurrent.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Title: Test
 * @Description:
 * @author: tangyao
 * @date: 2022/3/24 18:21
 * @Version: 1.0
 */

public class Test {
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1000, 1000, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));

    static List<Shop> shops = Stream.generate(() -> new Shop(UUID.randomUUID().toString())).limit(100).collect(Collectors.toList());

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
//        Future<Double> futurePrice = shop.getPriceAsync("My favorite procduct");
//        long invocationTime = (System.nanoTime() - start) / 1_000_000;
//        System.out.println("Invocation returned after " + invocationTime + " msecs");
//
//        Thread.sleep(300L);
//
//        try {
//            Double aDouble = futurePrice.get();
//            System.out.printf("Price is %.2f%n", aDouble);
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        long retrievalTime = (System.nanoTime() - start) / 1_000_000;
//        System.out.println("Price returned after " + retrievalTime + " msecs");

//        start = System.nanoTime();
//        System.out.println(findPrices("myIPhone111"));
//        long duration = (System.nanoTime() - start) / 1_000_000;
//        System.out.println("Done in " + duration + " msecs");

//        start = System.nanoTime();
//        System.out.println(findPrices2("my9"));
//        long duration = (System.nanoTime() - start) / 1_000_000;
//        System.out.println("Done in " + duration + " msecs");
//        start = System.nanoTime();
//        System.out.println(findPrices3("my9"));
//        long duration = (System.nanoTime() - start) / 1_000_000;
//        System.out.println("Done in " + duration + " msecs");
//
//        start = System.nanoTime();
//        System.out.println(findPrices4("my9"));
//        long duration = (System.nanoTime() - start) / 1_000_000;
//        System.out.println("Done in " + duration + " msecs");

        String product = "";
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> 1.0)
                .thenCombine(
                        CompletableFuture.supplyAsync(() -> {
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            return 2.1;
                        }).completeOnTimeout(2.0, 1, TimeUnit.MILLISECONDS),
                        (price, rate) -> price * rate
                ).orTimeout(3, TimeUnit.MILLISECONDS);
        Double aDouble = future.get();
        System.out.println("aDouble = " + aDouble);

        System.out.println("==================");
        CompletableFuture<Double> future2 = CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 1.0;
                })
                .completeOnTimeout(1.0, 1, TimeUnit.MILLISECONDS)
                .thenCompose(a -> CompletableFuture.supplyAsync(() -> a + 2.1))
                .orTimeout(3, TimeUnit.SECONDS);

        Double aDouble1 = future2.get();
        System.out.println("aDouble1 = " + aDouble1);
        System.out.println("=============");
        Stream<CompletableFuture<String>> myPhone = findPricesStream("myPhone");
        CompletableFuture[] completableFutures = myPhone.map(f -> f.thenAccept(
                x -> {
                    randomDelay();
                    System.out.println(x + "(done in " + (System.nanoTime() - start) / 1_000_000 + " msecs)");
                }
        )).toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(completableFutures).join();


        CompletableFuture<Integer> a = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });

        CompletableFuture<Integer> b = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2;
        });

        CompletableFuture<Object> c = CompletableFuture.anyOf(a, b);
        Object o = c.get();
        System.out.println("o = " + o);


    }

    public static List<String> findPrices(String product) {
        List<String> collect = shops.parallelStream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
        return collect;
    }

    public static List<String> findPrices2(String product) {

        List<CompletableFuture<String>> priceFutures = shops.stream().map(shop ->
                CompletableFuture.supplyAsync(
                        () -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)),
                        threadPoolExecutor
                )).collect(Collectors.toList());

        return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    public static List<String> findPrices3(String product) {

        return shops.stream()
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(DisCount::applyDiscount)
                .collect(Collectors.toList());
    }

    public static List<String> findPrices4(String product) {

        List<CompletableFuture<String>> priceFuture = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), threadPoolExecutor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> DisCount.applyDiscount(quote), threadPoolExecutor)))
                .collect(Collectors.toList());
        return priceFuture.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public static Stream<CompletableFuture<String>> findPricesStream(String product) {

        return shops.stream()
                .map(shop ->
                        CompletableFuture.supplyAsync(() -> shop.getPrice(product), threadPoolExecutor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(() -> DisCount.applyDiscount(quote), threadPoolExecutor)));
    }


    public static void randomDelay() {
        int delay = 500 + new Random().nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}