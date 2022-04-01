package com.tang.modernjavainaction.chap10.methodchaining;


import com.tang.demo.chap10.Trade;
import com.tang.modernjavainaction.chap10.methodchaining.MethodChainingOrderBuilder;
import com.tang.demo.chap10.methodchaining.StockBuilder;

/**
 * @Title: TradeBuilder
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 11:02
 * @Version: 1.0
 */

public class TradeBuilder {

    private final MethodChainingOrderBuilder builder;
    public final Trade trade = new Trade();

    public TradeBuilder(MethodChainingOrderBuilder builder, Trade.Type type, int quantity) {
        this.builder = builder;
        trade.setType(type);
        trade.setQuantity(quantity);
    }

    public StockBuilder stock(String symbol) {
        return new StockBuilder(builder, trade, symbol);
    }
}