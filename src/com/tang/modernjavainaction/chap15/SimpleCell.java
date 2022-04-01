package com.tang.modernjavainaction.chap15;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;


/**
 * @Title: SimpleCell
 * @Description:
 * @author: tangyao
 * @date: 2022/3/24 11:17
 * @Version: 1.0
 */

public class SimpleCell implements Publisher<Integer>, Subscriber<Integer> {

    private int value = 0;
    private String name;

    private List<Subscriber> subscribers = new ArrayList<>();

    public SimpleCell(String name) {
        this.name = name;
    }

    @Override
    public void onNext(Integer item) {
        this.value = item;
        System.out.println(this.name + ":" + this.value);
        notifyAllSubscribers();
    }

    private void notifyAllSubscribers() {
        subscribers.forEach(subscriber -> subscriber.onNext(this.value));
    }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        subscribers.add(subscriber);
    }
}