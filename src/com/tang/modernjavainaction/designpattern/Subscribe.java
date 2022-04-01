package com.tang.modernjavainaction.designpattern;


/**
 * @Title: Subscribe
 * @Description:
 * @author: tangyao
 * @date: 2022/3/24 15:16
 * @Version: 1.0
 */

public interface Subscribe<T> {

    void onEvent(T t);
}