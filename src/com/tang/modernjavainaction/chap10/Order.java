package com.tang.modernjavainaction.chap10;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Order
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 10:53
 * @Version: 1.0
 */
@Data
public class Order {

    private String customer;
    private List<Trade> trades = new ArrayList<>();

    public void addTrade(Trade trade) {
        trades.add(trade);
    }

    public double getValue() {
        return trades.stream().mapToDouble(Trade::getValue).sum();
    }
}