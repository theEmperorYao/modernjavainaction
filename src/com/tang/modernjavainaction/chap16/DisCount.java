package com.tang.modernjavainaction.chap16;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

import static com.tang.demo.chap16.Shop.delay;

/**
 * @Title: DisCount
 * @Description:
 * @author: tangyao
 * @date: 2022/3/28 11:06
 * @Version: 1.0
 */

public class DisCount {
    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLAINUM(15), DIAMOND(20);
        private final int percentage;

        Code(int percent) {
            this.percentage = percent;
        }


    }
    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " + DisCount.apply(quote.getPrice(), quote.getDiscountCode());
    }

    public static double apply(double price, Code code) {
        delay();
        double v = price * (100 - code.percentage) / 100;
        double v1 = new BigDecimal(v).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return v1;

    }

}