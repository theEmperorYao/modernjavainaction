package com.tang.modernjavainaction.chap10.methodchaining;


import com.tang.demo.chap10.Order;
import com.tang.demo.chap10.Trade;

/**
 * @Title: MethodChainingOrderBuilder
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 11:00
 * @Version: 1.0
 */

public class MethodChainingOrderBuilder {

    public final Order order = new Order();

    private MethodChainingOrderBuilder(String customer) {
        order.setCustomer(customer);
    }

    public static MethodChainingOrderBuilder forCustomer(String customer) {
        return new MethodChainingOrderBuilder(customer);
    }

    public TradeBuilder buy(int quantity) {
        return new TradeBuilder(this, Trade.Type.BUY, quantity);
    }

    public TradeBuilder sell(int quantity) {
        return new TradeBuilder(this, Trade.Type.SELL, quantity);
    }

    public MethodChainingOrderBuilder addTrade(Trade trade) {
        order.addTrade(trade);
        return this;
    }

    public Order end(){
        return order;
    }
}