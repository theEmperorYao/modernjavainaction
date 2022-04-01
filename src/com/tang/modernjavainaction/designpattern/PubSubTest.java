package com.tang.modernjavainaction.designpattern;


/**
 * @Title: PubSubTest
 * @Description:
 * @author: tangyao
 * @date: 2022/3/24 15:19
 * @Version: 1.0
 */

public class PubSubTest {

    public static void main(String[] args) {

        SimpleCell c1 = new SimpleCell("C1");
        SimpleCell c2 = new SimpleCell("C2");
        SimpleCell c4 = new SimpleCell("C4");
        AirthmeticCell c3 = new AirthmeticCell("C3");
        AirthmeticCell c5 = new AirthmeticCell("C5");


        c1.subscribe(c3::setLeft);
        c2.subscribe(c3::setRight);
        c3.subscribe(c5::setLeft);
        c4.subscribe(c5::setRight);
        c1.onEvent(10);
        c2.onEvent(20);
        c4.onEvent(100);



    }
}