package com.agoda.pf.util;

public class PFCalculator {

    public static PFResult calculate(double frozenPrice, double currentPrice, double deposit, double maxCap) {
        double savings = 0;
        double finalPrice;

        if (currentPrice > frozenPrice) savings = Math.min(currentPrice - frozenPrice, maxCap);

        finalPrice = currentPrice - deposit - savings;

        return new PFResult(finalPrice, savings);
    }
}
