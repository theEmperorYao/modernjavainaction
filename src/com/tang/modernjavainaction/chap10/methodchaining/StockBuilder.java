package com.tang.modernjavainaction.chap10.methodchaining;


import com.tang.demo.chap10.Stock;
import com.tang.demo.chap10.Trade;

/**
 * @Title: StockBuilder
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 11:04
 * @Version: 1.0
 */

public class StockBuilder {

    private final MethodChainingOrderBuilder builder;
    private final Trade trade;
    private final Stock stock = new Stock();

    public StockBuilder(MethodChainingOrderBuilder builder, Trade trade, String symbol) {
        this.builder = builder;
        this.trade = trade;
        stock.setSymbol(symbol);
    }

    public TradeBuilderWithStock on(String market) {
        stock.setMarket(market);
        trade.setStock(stock);
        return new TradeBuilderWithStock(builder, trade);
    }

}