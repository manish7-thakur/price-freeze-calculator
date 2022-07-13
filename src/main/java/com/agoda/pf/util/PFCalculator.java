package com.agoda.pf.util;

public class PFCalculator {

    public static PFResult calculate(double frozenPrice, double currentPrice, double deposit, double maxCap) {
        double newPrice = Math.min(currentPrice, frozenPrice);
        if(maxCap > 0 && currentPrice - frozenPrice > maxCap) {
            newPrice = currentPrice - maxCap;
            currentPrice = currentPrice - maxCap;
        }
        double finalPrice = newPrice - deposit;

        double savings = Math.abs(currentPrice - frozenPrice);
        return new PFResult(finalPrice, savings);
    }
}
