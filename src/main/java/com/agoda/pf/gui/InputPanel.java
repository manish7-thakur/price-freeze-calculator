package com.agoda.pf.gui;


import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class InputPanel extends JPanel {
    private List<DocumentListener> listeners;

    public InputPanel() {
        listeners = new ArrayList<>();
        setLayout(new GridLayout(3, 2));
        add(new JLabel("Frozen Price"));
        NumberFormatter formatter = new NumberFormatter(NumberFormat.getNumberInstance());
        add(new JFormattedTextField(formatter));
        add(new JLabel("Deposit Made"));
        add(new JFormattedTextField(formatter));
        add(new JLabel("Max Cap"));
        add(new JFormattedTextField(formatter));
    }

    public void addInputChangeListeners(DocumentListener listener) {
        listeners.add(listener);
    }

    public int getInputChangeListenersCount() {
        return listeners.size();
    }
}
