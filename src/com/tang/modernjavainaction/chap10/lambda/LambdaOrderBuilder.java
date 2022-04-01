package com.tang.modernjavainaction.chap10.lambda;


import com.tang.modernjavainaction.chap10.Order;
import com.tang.modernjavainaction.chap10.Trade;

import java.util.function.Consumer;

/**
 * @Title: MethodChainingOrderBuilder
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 11:00
 * @Version: 1.0
 */

public class LambdaOrderBuilder {

    public final Order order = new Order();

    public static Order order(Consumer<LambdaOrderBuilder> consumer) {
        LambdaOrderBuilder builder = new LambdaOrderBuilder();
        consumer.accept(builder);
        return builder.order;
    }

    public void forCustomer(String customer) {
        order.setCustomer(customer);
    }

    public void buy(Consumer<TradeBuilder> consumer) {
        trade(consumer, Trade.Type.BUY);
    }

    public void sell(Consumer<TradeBuilder> consumer) {
        trade(consumer, Trade.Type.SELL);
    }

    private void trade(Consumer<TradeBuilder> consumer, Trade.Type type) {
        TradeBuilder builder = new TradeBuilder();
        builder.trade.setType(type);
        consumer.accept(builder);
        order.addTrade(builder.trade);
    }


}