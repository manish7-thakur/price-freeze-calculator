package com.agoda.pf.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PFCalculatorTest {
    @Test
    @DisplayName("Price decreased")
    public void priceDecWithoutMaxCap() {
        PFResult result = PFCalculator.calculate(90.40, 85.25, 10.12, 10);
        Assertions.assertEquals(75.13, result.getFinalPrice());
        Assertions.assertEquals(0, result.getSavings());
    }

    @Test
    @DisplayName("Price increased and increase is less than cap")
    public void priceIncWithInMaxCapLimit() {
        PFResult result = PFCalculator.calculate(100.40, 115.25, 10.12, 20.15);
        Assertions.assertEquals(90.28, result.getFinalPrice());
        Assertions.assertEquals(14.849999999999994, result.getSavings());
    }

    @Test
    @DisplayName("Price increased and increase is more than cap")
    public void priceIncMoreThanMaxCap() {
        PFResult result = PFCalculator.calculate(100.40, 130.30, 15.12, 20.15);
        Assertions.assertEquals(95.03, result.getFinalPrice());
        Assertions.assertEquals(20.15, result.getSavings());
    }
}
