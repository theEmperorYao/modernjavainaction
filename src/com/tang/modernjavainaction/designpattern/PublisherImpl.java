package com.tang.modernjavainaction.designpattern;


import java.util.ArrayList;
import java.util.List;

/**
 * @Title: PubLisherImpl
 * @Description:
 * @author: tangyao
 * @date: 2022/3/24 15:20
 * @Version: 1.0
 */

public class PublisherImpl implements Publisher<Integer> {

    List<Subscribe> subscribes = new ArrayList<>();

    @Override
    public void subscribe(Subscribe<Integer> subscribe) {
        subscribes.add(subscribe);
    }




}