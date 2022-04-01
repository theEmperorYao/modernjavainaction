package com.tang.modernjavainaction.chap16;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Queue;

/**
 * @Title: Quote
 * @Description:
 * @author: tangyao
 * @date: 2022/3/28 11:11
 * @Version: 1.0
 */

@Data
public final class Quote {
    private final String shopName;
    private final double price;
    private final DisCount.Code discountCode;

    /**
     */
    public Quote(String shopName, double price, DisCount.Code discountCode) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }

    public static Quote parse(String s) {
        String[] split = s.split(":");
        String shopName = split[0];
        double price = Double.parseDouble(split[1]);
        DisCount.Code discountCode = DisCount.Code.valueOf(split[2]);
        return new Quote(shopName, price, discountCode);

    }


}