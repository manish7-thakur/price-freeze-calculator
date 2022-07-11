package com.agoda.pf.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PFCalculatorTest {
    @Test
    public void calculatesFinalPriceAndSavings() {
        PFResult result = PFCalculator.calculate(100.40, 120.50, 20.12);
        Assertions.assertEquals(80.28, result.getFinalPrice());

        result = PFCalculator.calculate(90.40, 85.25, 10.12);
        Assertions.assertEquals(75.13, result.getFinalPrice());
    }
}
