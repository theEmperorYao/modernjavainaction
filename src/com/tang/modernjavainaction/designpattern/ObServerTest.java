package com.tang.modernjavainaction.designpattern;


/**
 * @Title: ObServerTest
 * @Description:
 * @author: tangyao
 * @date: 2022/3/24 15:07
 * @Version: 1.0
 */

public class ObServerTest {

    public static void main(String[] args) {

        Feed feed = new Feed();

        feed.registerObserver(sweet -> {
            if (sweet.contains("1")) {
                System.out.println(sweet);
            }
        });

        feed.registerObserver(sweet -> {
            if (sweet.contains("2")) {
                System.out.println(sweet);
            }
        });

        feed.registerObserver(sweet -> {
            if (sweet.contains("3")) {
                System.out.println(sweet);
            }
        });

        feed.notifyObservers("1");


    }
}