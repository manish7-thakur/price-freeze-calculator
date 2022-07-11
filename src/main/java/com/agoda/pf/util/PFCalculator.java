package com.agoda.pf.util;

public class PFCalculator {

    public static PFResult calculate(double frozenPrice, double currentPrice, double deposit) {
        double newPrice = Math.min(currentPrice, frozenPrice);
        double finalPrice = newPrice - deposit;
        double savings = Math.abs(currentPrice - frozenPrice);
        return new PFResult(finalPrice, savings);
    }
}
