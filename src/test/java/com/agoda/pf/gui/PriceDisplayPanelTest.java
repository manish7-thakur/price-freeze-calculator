package com.agoda.pf.gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class PriceDisplayPanelTest {
    @Test
    public void addsLabelToDisplayPrice() {
        JPanel panel = new PriceDisplayPanel();
        Assertions.assertEquals("0", ((JLabel)panel.getComponents()[0]).getText());
    }
}
