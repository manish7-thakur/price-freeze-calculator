package com.agoda.pf.gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

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
        JFormattedTextField frozenPriceMock = Mockito.mock(JFormattedTextField.class);
        JFormattedTextField currentPriceMock = Mockito.mock(JFormattedTextField.class);
        JFormattedTextField depositMock = Mockito.mock(JFormattedTextField.class);
        JFormattedTextField maxCapMock = Mockito.mock(JFormattedTextField.class);
        panel.setFrozenPriceTextField(frozenPriceMock);
        panel.setCurrentPriceTextField(currentPriceMock);
        panel.setDepositTextField(depositMock);
        panel.setMaxCapTextField(maxCapMock);
        Document frozenPriceDocumentMock = Mockito.mock(Document.class);
        Document currentPriceDocumentMock = Mockito.mock(Document.class);
        Document depositDocumentMock = Mockito.mock(Document.class);
        Document maxCapDocumentMock = Mockito.mock(Document.class);

        Mockito.when(frozenPriceMock.getDocument()).thenReturn(frozenPriceDocumentMock);
        Mockito.when(currentPriceMock.getDocument()).thenReturn(currentPriceDocumentMock);
        Mockito.when(depositMock.getDocument()).thenReturn(depositDocumentMock);
        Mockito.when(maxCapMock.getDocument()).thenReturn(maxCapDocumentMock);
        DocumentListener documentListenerMock = Mockito.mock(DocumentListener.class);
        panel.addInputChangeListeners(documentListenerMock);

        Mockito.verify(frozenPriceDocumentMock).addDocumentListener(documentListenerMock);
        Mockito.verify(currentPriceDocumentMock).addDocumentListener(documentListenerMock);
        Mockito.verify(depositDocumentMock).addDocumentListener(documentListenerMock);
        Mockito.verify(maxCapDocumentMock).addDocumentListener(documentListenerMock);
    }
}
