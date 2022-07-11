package com.agoda.pf.event.listener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class InputChangeListener implements DocumentListener {

    private final JLabel label;

    public InputChangeListener(JLabel label) {
        this.label = label;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        label.setText("");
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        label.setText("");
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
