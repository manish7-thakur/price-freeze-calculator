package com.agoda.pf.util;

public class PFCalculator {

    public static PFResult calculate(double frozenPrice, double currentPrice, double deposit) {
        double finalPrice = frozenPrice;
        return new PFResult(finalPrice);
    }
}
