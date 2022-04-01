package com.tang.modernjavainaction.designpattern;


/**
 * @Title: Subject
 * @Description:
 * @author: tangyao
 * @date: 2022/3/24 15:04
 * @Version: 1.0
 */

public interface Subject {

    /**
     * 注册观察者
     * @param obServer
     */
    void registerObserver(ObServer obServer);

    /**
     * 通知观察者们
     */
    void notifyObservers(String sweet);

}