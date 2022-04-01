package com.tang.modernjavainaction.chap15;


/**
 * @Title: Test1
 * @Description:
 * @author: tangyao
 * @date: 2022/3/24 11:18
 * @Version: 1.0
 */


public class Test1 {

    public static void main(String[] args) {
        SimpleCell c1 = new SimpleCell("C1");
        SimpleCell c2 = new SimpleCell("C2");
        SimpleCell c4 = new SimpleCell("C4");
        ArithmeticCell c3 = new ArithmeticCell("C3");
        ArithmeticCell c5 = new ArithmeticCell("C5");

        c1.subscribe(c3::setLeft);
        c2.subscribe(c3::setRight);

        c3.subscribe(c5::setLeft);
        c4.subscribe(c5::setRight);

        c1.onNext(10);
        c2.onNext(20);
        c1.onNext(15);

        c4.onNext(1);
        c4.onNext(3);


    }
}