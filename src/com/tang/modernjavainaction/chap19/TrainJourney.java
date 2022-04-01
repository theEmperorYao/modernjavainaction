package com.tang.modernjavainaction.chap19;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Title: TrainJourney
 * @Description:
 * @author: tangyao
 * @date: 2022/3/30 14:12
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
public class TrainJourney {
    public int price;
    public TrainJourney onward;

    static TrainJourney link(TrainJourney a, TrainJourney b) {
        if (a == null) {
            return b;
        }
        TrainJourney t = a;
        while (t.onward != null) {
            t = t.onward;
        }
        t.onward = b;
        return a;
    }

    static TrainJourney append(TrainJourney a, TrainJourney b) {
        return a == null ? b : new TrainJourney(a.price, append(a.onward, b));
    }

}