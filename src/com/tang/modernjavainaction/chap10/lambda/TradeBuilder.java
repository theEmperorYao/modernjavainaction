package com.tang.modernjavainaction.chap10.lambda;


import com.tang.modernjavainaction.chap10.Trade;

import java.util.function.Consumer;

/**
 * @Title: TradeBuilder
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 11:02
 * @Version: 1.0
 */

public class TradeBuilder {

    public final Trade trade = new Trade();


    public TradeBuilder quantity(int quantity) {
        trade.setQuantity(quantity);
        return this;
    }

    public TradeBuilder price(double price) {
        trade.setPrice(price);
        return this;
    }

    public void stock(Consumer<StockBuilder> consumer) {
        StockBuilder builder = new StockBuilder();
        consumer.accept(builder);
        trade.setStock(builder.stock);
    }
}