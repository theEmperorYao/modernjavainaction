package com.tang.modernjavainaction.chap19;


/**
 * @Title: Test
 * @Description:
 * @author: tangyao
 * @date: 2022/3/30 14:13
 * @Version: 1.0
 */

public class Test {
    public static void main(String[] args) {
        TrainJourney b1 = new TrainJourney(4, null);
        TrainJourney b = new TrainJourney(3, b1);
        TrainJourney a1 = new TrainJourney(2, null);
        TrainJourney a = new TrainJourney(1, a1);
//        TrainJourney link = TrainJourney.link(a, b);
        TrainJourney append = TrainJourney.append(a, b);

        print(append);

        // 创建一个随机数


        

    }

    private static void print(TrainJourney link) {
        while (link != null) {
            System.out.println(link);
            link = link.onward;
        }
    }
}