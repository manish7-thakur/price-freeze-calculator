package com.agoda.pf.event.listener;

import com.agoda.pf.util.PFCalculator;
import com.agoda.pf.util.PFResult;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class InputChangeListener implements DocumentListener {

    private final JLabel label;
    private double frozenPrice;
    private double currentPrice;
    private double deposit;

    public InputChangeListener(JLabel label) {
        this.label = label;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updatePrice(e.getDocument());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updatePrice(e.getDocument());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

    public double getFrozenPrice() {
        return frozenPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public double getDeposit() {
        return deposit;
    }

    private void updatePrice(Document d) {
        String name = (String) d.getProperty("name");
        if (name.equals("frozen-price")) frozenPrice = getPrice(d);
        else if (name.equals("current-price")) currentPrice = getPrice(d);
        else if (name.equals("deposit")) deposit = getPrice(d);
        PFResult result = PFCalculator.calculate(frozenPrice, currentPrice, deposit, 0);
        label.setText("final price : " + result.getFinalPrice() + "     total savings : " + result.getSavings());
    }

    private Double getPrice(Document doc) {
        double txt;
        try {
            txt = Double.parseDouble(doc.getText(0, doc.getLength()));
        } catch (BadLocationException | NumberFormatException e) {
            txt = 0;
        }
        return txt;
    }
}
