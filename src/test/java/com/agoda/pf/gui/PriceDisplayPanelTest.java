package com.agoda.pf.gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class PriceDisplayPanelTest {
    @Test
    public void addsLabelToDisplayPriceAtBorderLayoutCenter() {
        JPanel panel = new PriceDisplayPanel();
        JLabel label = (JLabel) panel.getComponents()[0];
        Assertions.assertEquals("0", label.getText());
        Assertions.assertEquals("AgodaSansText-Bold", label.getFont().getFontName());
        Assertions.assertEquals("BorderLayout", panel.getLayout().getClass().getSimpleName());
    }

    @Test
    public void getAReferenceToDisplayPrice() {
        PriceDisplayPanel panel = new PriceDisplayPanel();
        Assertions.assertEquals("0", panel.getDisplayLabel().getText());
    }
}
