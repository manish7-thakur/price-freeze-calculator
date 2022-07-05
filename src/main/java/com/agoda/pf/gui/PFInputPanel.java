package com.agoda.pf.gui;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class PFInputPanel extends JPanel {
    public PFInputPanel() {
        setLayout(new GridLayout(3, 2));
        add(new JLabel("Frozen Price"));
        NumberFormatter formatter = new NumberFormatter(NumberFormat.getNumberInstance());
        add(new JFormattedTextField(formatter));
        add(new JLabel("Deposit Made"));
        add(new JFormattedTextField(formatter));
        add(new JLabel("Max Cap"));
        add(new JFormattedTextField(formatter));
    }
}
