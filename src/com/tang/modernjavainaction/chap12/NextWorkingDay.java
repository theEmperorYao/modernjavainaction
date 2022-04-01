package com.tang.modernjavainaction.chap12;


import java.time.DayOfWeek;
import java.time.temporal.*;

/**
 * @Title: NextWorkingDay
 * @Description:
 * @author: tangyao
 * @date: 2022/3/23 10:26
 * @Version: 1.0
 */

public class NextWorkingDay implements TemporalAdjuster {


    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int dayToAdd = 1;
        if (dayOfWeek == DayOfWeek.FRIDAY) {
            dayToAdd = 3;
        } else if (dayOfWeek == DayOfWeek.SATURDAY) {
            dayToAdd = 2;
        }

        return temporal.plus(dayToAdd, ChronoUnit.DAYS);

    }
}