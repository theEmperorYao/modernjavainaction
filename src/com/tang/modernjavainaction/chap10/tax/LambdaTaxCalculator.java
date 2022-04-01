package com.tang.modernjavainaction.chap10.tax;


import com.tang.modernjavainaction.chap10.Order;

import java.util.function.DoubleUnaryOperator;

/**
 * @Title: LambdaTaxCalculator
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 15:02
 * @Version: 1.0
 */

public class LambdaTaxCalculator {

    public DoubleUnaryOperator taxFunction = DoubleUnaryOperator.identity();

    public LambdaTaxCalculator with(DoubleUnaryOperator f) {
        taxFunction = taxFunction.andThen(f);
        return this;
    }

    public double calculate(Order order) {
        return taxFunction.applyAsDouble(order.getValue());
    }
}