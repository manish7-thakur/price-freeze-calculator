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
        setUpMocks("frozen-price", "100.21");
        InOrder order = Mockito.inOrder(mockLabel);

        listener.insertUpdate(documentEvent);
        Assertions.assertEquals(100.21, listener.getFrozenPrice());
        order.verify(mockLabel).setText("final price : 0.0     total savings : 100.21");

        setUpMocks("current-price", "121.34");
        listener.insertUpdate(documentEvent);
        Assertions.assertEquals(121.34, listener.getCurrentPrice());
        order.verify(mockLabel).setText("final price : 100.21     total savings : 21.13000000000001");

        setUpMocks("deposit", "21.35");
        listener.insertUpdate(documentEvent);
        Assertions.assertEquals(21.35, listener.getDeposit());
        order.verify(mockLabel).setText("final price : 78.85999999999999     total savings : 21.13000000000001");

        setUpMocks("max-cap", "15.35");
        listener.insertUpdate(documentEvent);
        Assertions.assertEquals(21.35, listener.getDeposit());
        order.verify(mockLabel).setText("final price : 84.64000000000001     total savings : 5.780000000000015");
    }

    @Test
    public void updatesNewPriceOnRemove() throws BadLocationException {
        listener = new InputChangeListener(mockLabel);
        Mockito.reset(mockLabel);
        setUpMocks("frozen-price", "100.21");
        InOrder order = Mockito.inOrder(mockLabel);

        listener.removeUpdate(documentEvent);
        Assertions.assertEquals(100.21, listener.getFrozenPrice());
        order.verify(mockLabel).setText("final price : 0.0     total savings : 100.21");

        setUpMocks("current-price", "121.34");
        listener.removeUpdate(documentEvent);
        Assertions.assertEquals(121.34, listener.getCurrentPrice());
        order.verify(mockLabel).setText("final price : 100.21     total savings : 21.13000000000001");

        setUpMocks("deposit", "21.35");
        listener.removeUpdate(documentEvent);
        Assertions.assertEquals(21.35, listener.getDeposit());
        order.verify(mockLabel).setText("final price : 78.85999999999999     total savings : 21.13000000000001");

        setUpMocks("max-cap", "15.35");
        listener.removeUpdate(documentEvent);
        Assertions.assertEquals(21.35, listener.getDeposit());
        order.verify(mockLabel).setText("final price : 84.64000000000001     total savings : 5.780000000000015");
    }

    @Test
    public void handlesNumberFormatException() throws BadLocationException {
        listener = new InputChangeListener(mockLabel);
        setUpMocks("frozen-price", "23.4rew");
        listener.insertUpdate(documentEvent);
        Assertions.assertEquals(0, listener.getFrozenPrice());
    }

    private void setUpMocks(String propertyName, String value) throws BadLocationException {
        Mockito.when(mockDocument.getProperty("name")).thenReturn(propertyName);
        Mockito.when(mockDocument.getText(Mockito.anyInt(), Mockito.anyInt())).thenReturn(value);
    }
}
