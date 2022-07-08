package com.agoda.pf.gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class InputPanelTest {
    @Test
    public void usesGridLayout() {
        JPanel panel = new InputPanel();
        Assertions.assertEquals("GridLayout", panel.getLayout().getClass().getSimpleName());
    }

    @Test
    public void addsRequiredInputComponents() {
        JPanel panel = new InputPanel();
        Assertions.assertEquals("Frozen Price", ((JLabel) panel.getComponent(0)).getText());
        Assertions.assertEquals("NumberFormatter", ((JFormattedTextField) panel.getComponent(1)).getFormatter().getClass().getSimpleName());
        Assertions.assertEquals("Deposit Made", ((JLabel) panel.getComponent(2)).getText());
        Assertions.assertEquals("NumberFormatter", ((JFormattedTextField) panel.getComponent(3)).getFormatter().getClass().getSimpleName());
        Assertions.assertEquals("Max Cap", ((JLabel) panel.getComponent(4)).getText());
        Assertions.assertEquals("NumberFormatter", ((JFormattedTextField) panel.getComponent(5)).getFormatter().getClass().getSimpleName());
    }
}