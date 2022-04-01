package com.tang.modernjavainaction.chap10.lambda;


import com.tang.modernjavainaction.chap10.Stock;
import com.tang.modernjavainaction.chap10.Trade;

/**
 * @Title: StockBuilder
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 11:04
 * @Version: 1.0
 */

public class StockBuilder {

    public Stock stock = new Stock();

    public void symbol(String symbol) {
        stock.setSymbol(symbol);
    }


    public void market(String market){
        stock.setMarket(market);
    }

}