package com.tang.modernjavainaction.chap10;


import com.tang.demo.chap10.lambda.LambdaOrderBuilder;
import com.tang.modernjavainaction.chap10.methodchaining.MethodChainingOrderBuilder;
import com.tang.demo.chap10.mix.MixBuilder;
import com.tang.demo.chap10.tax.LambdaTaxCalculator;
import com.tang.demo.chap10.tax.Tax;
import com.tang.demo.chap10.tax.TaxCalculator;

import static com.tang.modernjavainaction.chap10.nestedFunction.NestedFunctionOrderBuilder.*;

/**
 * @Title: Test01
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 10:56
 * @Version: 1.0
 */

public class Test01 {

    public static void main(String[] args) {
        Order order = new Order();
        order.setCustomer("BigBank");

        Trade trade1 = new Trade();
        trade1.setType(Trade.Type.BUY);

        Stock stock1 = new Stock();
        stock1.setSymbol("IBM");
        stock1.setMarket("NYSE");

        trade1.setStock(stock1);
        trade1.setPrice(125.00);
        trade1.setQuantity(80);
        order.addTrade(trade1);

        Trade trade2 = new Trade();
        trade1.setType(Trade.Type.BUY);

        Stock stock2 = new Stock();
        stock2.setSymbol("GOOGLE");
        stock2.setMarket("NASDAQ");

        trade2.setStock(stock2);
        trade2.setPrice(375.00);
        trade2.setQuantity(50);
        order.addTrade(trade2);


        Order end = MethodChainingOrderBuilder.forCustomer("BigBank")
                .buy(80)
                .stock("IBM")
                .on("NASDAQ")
                .at(125.00)
                .sell(50)
                .stock("GOOGLE")
                .on("NASDAQ")
                .at(375.00)
                .end();


        Order order1 = order("BigBank",
                buy(80,
                        stock("IBM", on("NYSE")),
                        at(125)),
                sell(50,
                        stock("GOOGLE", on("NASDAQ")),
                        at(375)));

        LambdaOrderBuilder.order(o -> {
            o.forCustomer("BigBank");
            o.buy(t -> {
                t.quantity(80);
                t.price(125.00);
                t.stock(s -> {
                    s.symbol("IBM");
                    s.market("NYSE");
                });
            });
            o.sell(t -> {
                t.quantity(50);
                t.price(375.00);
                t.stock(s -> {
                    s.symbol("GOOGLE");
                    s.market("NASDAQ");
                });
            });
        });


        Order order2 = MixBuilder.forCustomer("bigBank",
                MixBuilder.buy(t ->
                        t.quantity(80)
                                .stock("IBM")
                                .on("NYSE")
                                .at(125.00)),
                MixBuilder.sell(t ->
                        t.quantity(50)
                                .stock("GOOGLE")
                                .on("NSADAQ")
                                .at(125.00)));

        double calculate = new TaxCalculator()
                .withTaxGeneral()
                .withSurcharge()
                .withTaxRegional()
                .calculate(order);

        double calculate1 = new LambdaTaxCalculator()
                .with(Tax::regional)
                .with(Tax::surcharge)
                .calculate(order);


    }
}