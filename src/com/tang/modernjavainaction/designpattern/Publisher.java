package com.tang.modernjavainaction.designpattern;


/**
 * @Title: Publisher
 * @Description:
 * @author: tangyao
 * @date: 2022/3/24 15:15
 * @Version: 1.0
 */

public interface Publisher<T> {

    void subscribe(Subscribe<T> subscribe);

}