package com.tang.modernjavainaction.chap10.methodchaining;


import com.tang.demo.chap10.Trade;
import com.tang.modernjavainaction.chap10.methodchaining.MethodChainingOrderBuilder;

/**
 * @Title: TradeBuilderWithStock
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 11:10
 * @Version: 1.0
 */

public class TradeBuilderWithStock {

    private final MethodChainingOrderBuilder builder;
    private final Trade trade;

    public TradeBuilderWithStock(MethodChainingOrderBuilder builder, Trade trade) {
        this.builder = builder;
        this.trade = trade;
    }
    public MethodChainingOrderBuilder at(Double price){
        trade.setPrice(price);
        return builder.addTrade(trade);
    }

}