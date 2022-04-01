package com.tang.modernjavainaction.chap10.tax;


import com.tang.modernjavainaction.chap10.Order;

/**
 * @Title: Tax
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 14:50
 * @Version: 1.0
 */

public class Tax {

    public static double regional(double value) {
        return value * 1.1;
    }

    public static double general(double value) {
        return value * 1.3;
    }

    public static double surcharge(double value) {
        return value * 1.05;
    }

    public static double calculate(Order order, boolean useRegional, boolean useGeneral, boolean useSurcharge) {
        double value = order.getValue();
        if (useRegional) {
            value = Tax.regional(value);
        }
        if (useGeneral) {
            value = Tax.general(value);
        }
        if (useSurcharge) {
            value = Tax.surcharge(value);
        }
        return value;
    }
}