package com.tang.modernjavainaction.designpattern;


import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Feed
 * @Description:
 * @author: tangyao
 * @date: 2022/3/24 15:08
 * @Version: 1.0
 */

public class Feed implements Subject {

    List<ObServer> obServers = new ArrayList<>();

    @Override
    public void registerObserver(ObServer obServer) {
        obServers.add(obServer);
    }

    @Override
    public void notifyObservers(String sweet) {

        obServers.forEach(o -> o.notify(sweet));
    }
}