package com.tang.modernjavainaction.chap17;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

import java.security.PublicKey;
import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;


/**
 * @Title: Test
 * @Description:
 * @author: tangyao
 * @date: 2022/3/29 10:04
 * @Version: 1.0
 */

public class Test {

    public static void main(String[] args) {
        getTemperatures("New York ").subscribe(new TempSubscriber());
//        getCelsiusTemperatures("China").subscribe(new TempSubscriber());

//        Observable<String> strings = Observable.just("first", "second");
//        Observable<Long> onePerSec = Observable.interval(1, TimeUnit.SECONDS);
//        onePerSec.blockingSubscribe(i -> System.out.println(TempInfo.fetch("New York")));


    }

    public static Flow.Publisher<TempInfo> getCelsiusTemperatures(String town) {
        return subscriber -> {
            TempProcessor processor = new TempProcessor();
            processor.subscribe(subscriber);
            processor.onSubscribe(new TempSubscription(processor, town));
        };
    }

    private static Flow.Publisher<TempInfo> getTemperatures(String town) {
        return subscriber -> subscriber.onSubscribe(new TempSubscription(subscriber, town));
    }
}