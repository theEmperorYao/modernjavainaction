package com.tang.modernjavainaction.chap10.mix;


import com.tang.modernjavainaction.chap10.Stock;
import com.tang.modernjavainaction.chap10.Trade;

/**
 * @Title: StockBuilder
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 14:38
 * @Version: 1.0
 */

public class StockBuilder {
    private final TradeBuilder builder;
    private final Trade trade;
    private final Stock stock = new Stock();

    public StockBuilder(TradeBuilder builder, Trade trade, String symbol) {
        this.builder = builder;
        this.trade = trade;
        stock.setSymbol(symbol);
    }

    public TradeBuilder on(String market) {
        stock.setMarket(market);
        trade.setStock(stock);
        return builder;
    }

}