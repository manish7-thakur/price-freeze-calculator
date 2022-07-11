package com.agoda.pf.gui;


import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class InputPanel extends JPanel {
    private JFormattedTextField frozenPriceTextField = createFormattedTextFields("frozen-price");
    private JFormattedTextField currentPriceTextField = createFormattedTextFields("current-price");
    private JFormattedTextField depositTextField = createFormattedTextFields("deposit");
    private JFormattedTextField maxCapTextField = createFormattedTextFields("max-cap");

    public InputPanel() {
        setLayout(new GridLayout(4, 2));
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
        frozenPriceTextField.getDocument().addDocumentListener(listener);
        currentPriceTextField.getDocument().addDocumentListener(listener);
        depositTextField.getDocument().addDocumentListener(listener);
        maxCapTextField.getDocument().addDocumentListener(listener);
    }

    public void setFrozenPriceTextField(JFormattedTextField frozenPriceTextField) {
        this.frozenPriceTextField = frozenPriceTextField;
    }

    public void setCurrentPriceTextField(JFormattedTextField currentPriceTextField) {
        this.currentPriceTextField = currentPriceTextField;
    }

    public void setDepositTextField(JFormattedTextField depositTextField) {
        this.depositTextField = depositTextField;
    }

    public void setMaxCapTextField(JFormattedTextField maxCapTextField) {
        this.maxCapTextField = maxCapTextField;
    }

    private JFormattedTextField createFormattedTextFields(String propertyName) {
        NumberFormatter formatter = new NumberFormatter(NumberFormat.getNumberInstance());
        JFormattedTextField formattedTextField = new JFormattedTextField(formatter);
        formattedTextField.setValue(Double.valueOf(0.00));
        formattedTextField.getDocument().putProperty("name", propertyName);
        return formattedTextField;
    }
}
