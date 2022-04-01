package com.tang.modernjavainaction.designpattern;


import java.util.ArrayList;
import java.util.List;

/**
 * @Title: SimpleCell
 * @Description:
 * @author: tangyao
 * @date: 2022/3/24 15:23
 * @Version: 1.0
 */

public class SimpleCell implements Publisher<Integer>, Subscribe<Integer> {


    private int value;
    private String name;

    List<Subscribe> subscribes = new ArrayList<>();

    public SimpleCell(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Subscribe<Integer> subscribe) {
        subscribes.add(subscribe);
    }

    @Override
    public void onEvent(Integer number) {
        this.value = number;
        System.out.println(name + " : " + value);
        notifyAllSubscribers(number);
    }

    private void notifyAllSubscribers(Integer number) {
        subscribes.forEach(o -> o.onEvent(number));
    }
}