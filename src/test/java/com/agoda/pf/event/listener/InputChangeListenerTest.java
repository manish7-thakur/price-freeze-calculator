package com.agoda.pf.event.listener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InOrder;
import org.mockito.Mockito;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InputChangeListenerTest {
    JLabel mockLabel;
    InputChangeListener listener;
    DocumentEvent documentEvent;
    Document mockDocument;

    @BeforeAll
    public void setUp() {
        mockLabel = Mockito.mock(JLabel.class);
        documentEvent = Mockito.mock(DocumentEvent.class);
        mockDocument = Mockito.mock(Document.class);
        Mockito.when(documentEvent.getDocument()).thenReturn(mockDocument);
    }

    @Test
    public void updatesPriceParamsInsert() throws BadLocationException {
        listener = new InputChangeListener(mockLabel);
        Mockito.reset(mockLabel);
        setUpMocks("frozen-price", "10000.21");
        InOrder order = Mockito.inOrder(mockLabel);

        listener.insertUpdate(documentEvent);
        Assertions.assertEquals(10000.21, listener.getFrozenPrice());
        order.verify(mockLabel).setText("final price : 0     total savings : 0");

        setUpMocks("current-price", "10821.34");
        listener.insertUpdate(documentEvent);
        Assertions.assertEquals(10821.34, listener.getCurrentPrice());
        order.verify(mockLabel).setText("final price : 10,821.34     total savings : 0");

        setUpMocks("deposit", "212.35");
        listener.insertUpdate(documentEvent);
        Assertions.assertEquals(212.35, listener.getDeposit());
        order.verify(mockLabel).setText("final price : 10,608.99     total savings : 0");

        setUpMocks("max-cap", "135.35");
        listener.insertUpdate(documentEvent);
        Assertions.assertEquals(135.35, listener.getMaxCap());
        order.verify(mockLabel).setText("final price : 10,473.64     total savings : 135.35");
    }

    @Test
    public void updatesNewPriceOnRemove() throws BadLocationException {
        listener = new InputChangeListener(mockLabel);
        Mockito.reset(mockLabel);
        setUpMocks("frozen-price", "10320.21");
        InOrder order = Mockito.inOrder(mockLabel);

        listener.removeUpdate(documentEvent);
        Assertions.assertEquals(10320.21, listener.getFrozenPrice());
        order.verify(mockLabel).setText("final price : 0     total savings : 0");

        setUpMocks("current-price", "13421.34");
        listener.removeUpdate(documentEvent);
        Assertions.assertEquals(13421.34, listener.getCurrentPrice());
        order.verify(mockLabel).setText("final price : 13,421.34     total savings : 0");

        setUpMocks("deposit", "241.35");
        listener.removeUpdate(documentEvent);
        Assertions.assertEquals(241.35, listener.getDeposit());
        order.verify(mockLabel).setText("final price : 13,179.99     total savings : 0");

        setUpMocks("max-cap", "175.35");
        listener.removeUpdate(documentEvent);
        Assertions.assertEquals(175.35, listener.getMaxCap());
        order.verify(mockLabel).setText("final price : 13,004.64     total savings : 175.35");
    }

    @Test
    public void handlesParseException() throws BadLocationException {
        listener = new InputChangeListener(mockLabel);
        setUpMocks("frozen-price", "rw2f3.4rew");
        listener.insertUpdate(documentEvent);
        Assertions.assertEquals(0.0, listener.getFrozenPrice());
    }

    @Test
    public void parseDoublesWithComma() throws BadLocationException {
        listener = new InputChangeListener(mockLabel);
        setUpMocks("frozen-price", "1,234,5");
        listener.insertUpdate(documentEvent);
        Assertions.assertEquals(12345, listener.getFrozenPrice());
    }

    private void setUpMocks(String propertyName, String value) throws BadLocationException {
        Mockito.when(mockDocument.getProperty("name")).thenReturn(propertyName);
        Mockito.when(mockDocument.getText(Mockito.anyInt(), Mockito.anyInt())).thenReturn(value);
    }
}
