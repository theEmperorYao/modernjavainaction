package com.tang.modernjavainaction.chap10;


import lombok.Data;

import java.lang.reflect.Type;

/**
 * @Title: Trade
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 10:51
 * @Version: 1.0
 */
@Data
public class Trade {
    public enum Type {BUY, SELL}

    private Type type;

    private Stock stock;

    private int quantity;

    private double price;


    public double getValue() {
        return quantity * price;
    }
}