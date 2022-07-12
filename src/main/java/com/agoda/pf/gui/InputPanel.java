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
        JLabel frozenPrice = new JLabel("Frozen Price");
        Font agodaSansText = new Font("Agoda Sans Text", frozenPrice.getFont().getStyle(), frozenPrice.getFont().getSize());
        frozenPrice.setFont(agodaSansText);
        add(frozenPrice);
        add(frozenPriceTextField);
        JLabel currentPrice = new JLabel("Current Price");
        currentPrice.setFont(agodaSansText);
        add(currentPrice);
        add(currentPriceTextField);
        JLabel depositMade = new JLabel("Deposit Made");
        depositMade.setFont(agodaSansText);
        add(depositMade);
        add(depositTextField);
        JLabel maxCap = new JLabel("Max Cap (Not yet available)");
        maxCap.setFont(agodaSansText);
        add(maxCap);
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
