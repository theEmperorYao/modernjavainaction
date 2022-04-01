package com.tang.modernjavainaction.chap15;

/**
 * @Title: Publisher
 * @Description:
 * @author: tangyao
 * @date: 2022/3/24 12:03 2022/3/24
 * @Version: 1.0
 */

public interface Publisher<T> {
    void subscribe(Subscriber<? super T> subscriber);
}
