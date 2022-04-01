package com.tang.modernjavainaction.chap10.tax;


import com.tang.modernjavainaction.chap10.Order;

/**
 * @Title: TaxCalculator
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 14:55
 * @Version: 1.0
 */

public class TaxCalculator {

    private boolean useRegional;
    private boolean useGeneral;
    private boolean useSurcharge;

    public TaxCalculator withTaxRegional() {
        useRegional = true;
        return this;
    }

    public TaxCalculator withTaxGeneral() {
        useGeneral = true;
        return this;
    }

    public TaxCalculator withSurcharge() {
        useSurcharge = true;
        return this;
    }

    public double calculate(Order order) {
        return Tax.calculate(order, useRegional, useGeneral, useSurcharge);
    }


}