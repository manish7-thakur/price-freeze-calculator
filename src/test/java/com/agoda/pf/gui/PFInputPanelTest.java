package com.agoda.pf.gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class PFInputPanelTest {
    @Test
    public void usesGridLayout() {
        JPanel panel = new PFInputPanel();
        Assertions.assertEquals("GridLayout", panel.getLayout().getClass().getSimpleName());
    }

    @Test
    public void addsRequiredInputComponents() {
        JPanel panel = new PFInputPanel();
        Assertions.assertEquals("Frozen Price", ((JLabel) panel.getComponent(0)).getText());
        Assertions.assertEquals("NumberFormatter", ((JFormattedTextField) panel.getComponent(1)).getFormatter().getClass().getSimpleName());
    }
}
