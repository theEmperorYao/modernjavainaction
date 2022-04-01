package com.tang.modernjavainaction.chap17;


import java.util.concurrent.Flow;

/**
 * @Title: TempSubscriber
 * @Description:
 * @author: tangyao
 * @date: 2022/3/29 10:32
 * @Version: 1.0
 */

public class TempSubscriber implements Flow.Subscriber<TempInfo> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(TempInfo tempInfo) {
        System.out.println(tempInfo);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Done!");
    }
}