package com.tang.modernjavainaction.chap17;


import java.util.concurrent.*;

/**
 * @Title: TempSubscriber
 * @Description:
 * @author: tangyao
 * @date: 2022/3/29 10:20
 * @Version: 1.0
 */

public class TempSubscription implements Flow.Subscription {

    private final Flow.Subscriber<? super TempInfo> subscriber;
    private final String town;

    public TempSubscription(Flow.Subscriber<? super TempInfo> subscriber, String town) {
        this.subscriber = subscriber;
        this.town = town;
    }

    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1));

    @Override
    public void request(long n) {
        executor.submit(() -> {
            for (long i = 0; i < n; i++) {
                try {
                    subscriber.onNext(TempInfo.fetch(town));
                } catch (Exception e) {
                    subscriber.onError(e);
                    break;
                }
            }
        });

    }

    @Override
    public void cancel() {
        subscriber.onComplete();
    }

}