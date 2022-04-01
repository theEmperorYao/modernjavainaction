package com.tang.modernjavainaction.chap9;


import java.util.ArrayList;
import java.util.List;

/**
 * @Title: DesignPatternTest2
 * @Description:
 * @author: tangyao
 * @date: 2022/3/21 16:42
 * @Version: 1.0
 */


interface Observer {
    void notify(String tweet);
}

class NYTimes implements Observer {

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("NYTimes: " + tweet);
        }
    }
}

class Guardian implements Observer {

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen")) {
            System.out.println("Guardian: " + tweet);
        }
    }
}

class LeMonde implements Observer {

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("wine")) {
            System.out.println("LeMonde: " + tweet);
        }
    }
}

interface Subject {
    void registerObserver(Observer o);

    void notifyObservers(String tweet);
}

class Feed implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }
}

public class DesignPatternTest2 {

    public static void main(String[] args) {

        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());

        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("aaaa");
            }
        });

        f.notifyObservers("The queen money said her favourite book is Modern java in action");


    }
}