package com.tang.modernjavainaction.chap15;

/**
 * @Title: Subscriber
 * @Description:
 * @author: tangyao
 * @date: 2022/3/24 12:04 2022/3/24
 * @Version: 1.0
 */

public interface Subscriber<T> {
    void onNext(T t);
}
