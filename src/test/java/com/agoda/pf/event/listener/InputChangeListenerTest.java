package com.agoda.pf.event.listener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
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
        listener = new InputChangeListener(mockLabel);
    }

    @Test
    public void updatesPriceParamsInsert() throws BadLocationException {
        Mockito.reset(mockLabel);
        Mockito.when(documentEvent.getDocument()).thenReturn(mockDocument);
        Mockito.when(mockDocument.getProperty("name")).thenReturn("frozen-price");
        Mockito.when(mockDocument.getText(Mockito.anyInt(), Mockito.anyInt())).thenReturn("100.21");
        listener.insertUpdate(documentEvent);
        Assertions.assertEquals(100.21, listener.getFrozenPrice());
        Mockito.when(mockDocument.getProperty("name")).thenReturn("current-price");
        Mockito.when(mockDocument.getText(Mockito.anyInt(), Mockito.anyInt())).thenReturn("121.34");
        listener.insertUpdate(documentEvent);
        Assertions.assertEquals(121.34, listener.getCurrentPrice());
        Mockito.when(mockDocument.getProperty("name")).thenReturn("deposit");
        Mockito.when(mockDocument.getText(Mockito.anyInt(), Mockito.anyInt())).thenReturn("21.35");
        listener.insertUpdate(documentEvent);
        Assertions.assertEquals(21.35, listener.getDeposit());
        Mockito.verify(mockLabel, Mockito.times(3)).setText(Mockito.anyString());
    }

    @Test
    public void updatesNewPriceOnRemove() throws BadLocationException {
        Mockito.reset(mockLabel);
        Mockito.when(documentEvent.getDocument()).thenReturn(mockDocument);
        Mockito.when(mockDocument.getProperty("name")).thenReturn("frozen-price");
        Mockito.when(mockDocument.getText(Mockito.anyInt(), Mockito.anyInt())).thenReturn("100.21");
        listener.removeUpdate(documentEvent);
        Assertions.assertEquals(100.21, listener.getFrozenPrice());
        Mockito.when(mockDocument.getProperty("name")).thenReturn("current-price");
        Mockito.when(mockDocument.getText(Mockito.anyInt(), Mockito.anyInt())).thenReturn("121.34");
        listener.removeUpdate(documentEvent);
        Assertions.assertEquals(121.34, listener.getCurrentPrice());
        Mockito.when(mockDocument.getProperty("name")).thenReturn("deposit");
        Mockito.when(mockDocument.getText(Mockito.anyInt(), Mockito.anyInt())).thenReturn("21.35");
        listener.removeUpdate(documentEvent);
        Assertions.assertEquals(21.35, listener.getDeposit());
        Mockito.verify(mockLabel, Mockito.times(3)).setText(Mockito.anyString());
    }
}
