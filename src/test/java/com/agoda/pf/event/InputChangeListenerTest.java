package com.agoda.pf.event;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InputChangeListenerTest {
    JLabel mockLabel;
    DocumentListener listener;
    DocumentEvent documentEvent;

    @BeforeAll
    public void setUp() {
        mockLabel = Mockito.mock(JLabel.class);
        documentEvent = Mockito.mock(DocumentEvent.class);
        listener = new InputChangeListener(mockLabel);
    }

    @Test
    public void updatesNewPriceOnInsert() {
        Mockito.reset(mockLabel);
        listener.insertUpdate(documentEvent);
        Mockito.verify(mockLabel).setText("");
    }

    @Test
    public void updatesNewPriceOnRemove() {
        Mockito.reset(mockLabel);
        listener.removeUpdate(documentEvent);
        Mockito.verify(mockLabel).setText("");
    }
}
