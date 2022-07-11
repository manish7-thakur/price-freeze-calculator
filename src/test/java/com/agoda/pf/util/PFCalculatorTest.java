package com.agoda.pf.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PFCalculatorTest {
    @Test
    public void calculatesFinalPriceAndSavings() {
        PFResult result = PFCalculator.calculate(100.40, 120.50, 20.12);
        Assertions.assertEquals(100.40, result.getFinalPrice());
    }
}
