package com.agoda.pf.gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import javax.swing.event.DocumentListener;

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
        JFormattedTextField textField = (JFormattedTextField) panel.getComponent(1);
        Assertions.assertEquals("NumberFormatter", textField.getFormatter().getClass().getSimpleName());
        Assertions.assertEquals("frozen-price", textField.getDocument().getProperty("name"));

        Assertions.assertEquals("Current Price", ((JLabel) panel.getComponent(2)).getText());
        textField = (JFormattedTextField) panel.getComponent(3);
        Assertions.assertEquals("NumberFormatter", textField.getFormatter().getClass().getSimpleName());
        Assertions.assertEquals("current-price", textField.getDocument().getProperty("name"));

        Assertions.assertEquals("Deposit Made", ((JLabel) panel.getComponent(4)).getText());
        textField = (JFormattedTextField) panel.getComponent(5);
        Assertions.assertEquals("NumberFormatter", textField.getFormatter().getClass().getSimpleName());
        Assertions.assertEquals("deposit", textField.getDocument().getProperty("name"));

        Assertions.assertEquals("Max Cap", ((JLabel) panel.getComponent(6)).getText());
        textField = (JFormattedTextField) panel.getComponent(7);
        Assertions.assertEquals("NumberFormatter", textField.getFormatter().getClass().getSimpleName());
        Assertions.assertEquals("max-cap", textField.getDocument().getProperty("name"));
    }

    @Test
    public void allowsAddingListeners() {
        InputPanel panel = new InputPanel();
        panel.addInputChangeListeners(Mockito.mock(DocumentListener.class));
        Assertions.assertEquals(1, panel.getInputChangeListenersCount());
    }
}
