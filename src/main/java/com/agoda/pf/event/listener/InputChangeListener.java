package com.agoda.pf.event.listener;

import com.agoda.pf.util.PFCalculator;
import com.agoda.pf.util.PFResult;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.text.NumberFormat;
import java.text.ParseException;

public class InputChangeListener implements DocumentListener {

    private final JLabel label;
    private double frozenPrice;
    private double currentPrice;
    private double deposit;
    private double maxCap;

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

    public double getMaxCap() {
        return maxCap;
    }

    private void updatePrice(Document d) {
        String name = (String) d.getProperty("name");
        if (name.equals("frozen-price")) frozenPrice = getPrice(d);
        else if (name.equals("current-price")) currentPrice = getPrice(d);
        else if (name.equals("deposit")) deposit = getPrice(d);
        else if (name.equals("max-cap")) maxCap = getPrice(d);
        PFResult result = PFCalculator.calculate(frozenPrice, currentPrice, deposit, maxCap);
        String text = "final price : " + result.getFinalPrice() + "     total savings : " + result.getSavings();
        label.setText(text);
    }

    private Double getPrice(Document doc) {
        double txt;
        try {
            String text = doc.getText(0, doc.getLength());
            txt = NumberFormat.getNumberInstance().parse(text).doubleValue();
        } catch (BadLocationException | ParseException e) {
            txt = 0;
        }
        return txt;
    }
}
