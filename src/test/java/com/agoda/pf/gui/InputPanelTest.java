package com.agoda.pf.gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;

public class InputPanelTest {
    @Test
    public void usesGridLayout() {
        JPanel panel = new InputPanel();
        Assertions.assertEquals("GridLayout", panel.getLayout().getClass().getSimpleName());
        Assertions.assertEquals(4, ((GridLayout) panel.getLayout()).getRows());
        Assertions.assertEquals(2, ((GridLayout) panel.getLayout()).getColumns());
    }

    @Test
    public void addsRequiredInputComponents() {
        JPanel panel = new InputPanel();
        JLabel label = (JLabel) panel.getComponent(0);
        Assertions.assertEquals("Frozen Price", label.getText());
        Assertions.assertEquals("AgodaSansText-Regular", label.getFont().getFontName());
        JFormattedTextField textField = (JFormattedTextField) panel.getComponent(1);
        Assertions.assertEquals("NumberFormatter", textField.getFormatter().getClass().getSimpleName());
        Assertions.assertEquals("frozen-price", textField.getDocument().getProperty("name"));

        label = (JLabel) panel.getComponent(2);
        Assertions.assertEquals("Current Price", label.getText());
        Assertions.assertEquals("AgodaSansText-Regular", label.getFont().getFontName());
        textField = (JFormattedTextField) panel.getComponent(3);
        Assertions.assertEquals("NumberFormatter", textField.getFormatter().getClass().getSimpleName());
        Assertions.assertEquals("current-price", textField.getDocument().getProperty("name"));

        label = (JLabel) panel.getComponent(4);
        Assertions.assertEquals("Deposit Made", label.getText());
        Assertions.assertEquals("AgodaSansText-Regular", label.getFont().getFontName());
        textField = (JFormattedTextField) panel.getComponent(5);
        Assertions.assertEquals("NumberFormatter", textField.getFormatter().getClass().getSimpleName());
        Assertions.assertEquals("deposit", textField.getDocument().getProperty("name"));

        label = (JLabel) panel.getComponent(6);
        Assertions.assertEquals("Max Cap (Not yet available)", label.getText());
        Assertions.assertEquals("AgodaSansText-Regular", label.getFont().getFontName());
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
