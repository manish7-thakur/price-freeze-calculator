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
    private JFormattedTextField frozenPriceTextField = createFormattedTextFields("frozen-price");
    private JFormattedTextField currentPriceTextField = createFormattedTextFields("current-price");
    private JFormattedTextField depositTextField = createFormattedTextFields("deposit");
    private JFormattedTextField maxCapTextField = createFormattedTextFields("max-cap");


    public InputPanel() {
        listeners = new ArrayList<>();
        setLayout(new GridLayout(3, 2));
        add(new JLabel("Frozen Price"));
        add(frozenPriceTextField);
        add(new JLabel("Current Price"));
        add(currentPriceTextField);
        add(new JLabel("Deposit Made"));
        add(depositTextField);
        add(new JLabel("Max Cap"));
        add(maxCapTextField);
    }

    public void addInputChangeListeners(DocumentListener listener) {
        listeners.add(listener);
    }

    public int getInputChangeListenersCount() {
        return listeners.size();
    }

    private JFormattedTextField createFormattedTextFields(String propertyName) {
        NumberFormatter formatter = new NumberFormatter(NumberFormat.getNumberInstance());
        JFormattedTextField formattedTextField = new JFormattedTextField(formatter);
        formattedTextField.getDocument().putProperty("name", propertyName);
        return formattedTextField;
    }
}
