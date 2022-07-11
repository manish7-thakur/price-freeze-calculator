package com.agoda.pf.util;

public class PFResult {
    private double finalPrice;
    private double savings;

    public PFResult(double finalPrice, double savings) {
        this.finalPrice = finalPrice;
        this.savings = savings;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public double getSavings() {
        return savings;
    }
}
