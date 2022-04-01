package com.tang.modernjavainaction.chap10.mix;

import com.tang.modernjavainaction.chap10.Order;
import com.tang.modernjavainaction.chap10.Trade;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @Title: MixBuilder
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 14:26
 * @Version: 1.0
 */

public class MixBuilder {

    public static Order forCustomer(String customer, TradeBuilder... builders) {
        Order order = new Order();
        order.setCustomer(customer);
        Stream.of(builders).forEach(b -> order.addTrade(b.trade));
        return order;
    }

    public static TradeBuilder buy(Consumer<TradeBuilder> consumer) {
        return buildTrade(consumer, Trade.Type.BUY);
    }

    public static TradeBuilder sell(Consumer<TradeBuilder> consumer) {
        return buildTrade(consumer, Trade.Type.SELL);
    }

    private static TradeBuilder buildTrade(Consumer<TradeBuilder> consumer, Trade.Type type) {

        TradeBuilder builder = new TradeBuilder();
        builder.trade.setType(type);
        consumer.accept(builder);
        return builder;
    }
}