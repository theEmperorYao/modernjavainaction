package com.tang.modernjavainaction.chap16;


import lombok.Data;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @Title: Shop
 * @Description:
 * @author: tangyao
 * @date: 2022/3/24 18:21
 * @Version: 1.0
 */
@Data
public class Shop {

    private String name;

    public Shop(String name) {
        this.name = name;
    }


    public Future<Double> getPriceAsync2(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
//                int i = 1 / 0;
                futurePrice.complete(price);

            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }

        }).start();


        return futurePrice;

    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private double calculatePrice(String product) {
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public String getPrice(String product) {
        double price = calculatePrice(product);
        DisCount.Code code = DisCount.Code.values()[new Random().nextInt(DisCount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }


}