package com.tang.modernjavainaction.chap10.mix;


import com.tang.modernjavainaction.chap10.Trade;


/**
 * @Title: TradeBuilder
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 14:36
 * @Version: 1.0
 */

public class TradeBuilder {

    public Trade trade = new Trade();

    public TradeBuilder quantity(int quantity) {
        trade.setQuantity(quantity);
        return this;
    }

    public TradeBuilder at(double price) {
        trade.setPrice(price);
        return this;
    }
    public StockBuilder stock(String symbol){
        return new StockBuilder(this,trade,symbol);
    }
}