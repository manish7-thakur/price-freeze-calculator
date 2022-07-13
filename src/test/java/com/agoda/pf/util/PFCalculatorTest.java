package com.agoda.pf.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PFCalculatorTest {
    @Test
    @DisplayName("Price increased without maximum cap value")
    public void priceIncWithoutMaxCap() {
        PFResult result = PFCalculator.calculate(100.40, 120.50, 20.12, 0);
        Assertions.assertEquals(80.28, result.getFinalPrice());
        Assertions.assertEquals(20.099999999999994, result.getSavings());
    }

    @Test
    @DisplayName("Price decreased without maximum cap value")
    public void priceDecWithoutMaxCap() {
        PFResult result = PFCalculator.calculate(90.40, 85.25, 10.12, 0);
        Assertions.assertEquals(75.13, result.getFinalPrice());
        Assertions.assertEquals(5.150000000000006, result.getSavings());
    }

    @Test
    @DisplayName("Price increased with maximum cap value and increase is less than cap")
    public void priceIncWithInMaxCapLimit() {
        PFResult result = PFCalculator.calculate(100.40, 115.25, 10.12, 20.15);
        Assertions.assertEquals(90.28, result.getFinalPrice());
        Assertions.assertEquals(14.849999999999994, result.getSavings());
    }

    @Test
    @DisplayName("Price increased with maximum cap value and increase is less than cap")
    public void priceIncMoreThanMaxCap() {
        PFResult result = PFCalculator.calculate(100.40, 130.30, 15.12, 20.15);
        Assertions.assertEquals(95.03, result.getFinalPrice());
        Assertions.assertEquals(9.75, result.getSavings());
    }
}
