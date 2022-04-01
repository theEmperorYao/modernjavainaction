package com.tang.modernjavainaction.designpattern;


/**
 * @Title: ObServer
 * @Description:
 * @author: tangyao
 * @date: 2022/3/24 15:02
 * @Version: 1.0
 */

public interface ObServer {
    /**
     * 观察者通知
     *
     * @param sweet
*/
    void notify(String sweet);
}
