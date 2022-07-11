package com.agoda.pf.gui;

import javax.swing.*;

public class PriceDisplayPanel extends JPanel {
    private JLabel displayLabel;

    public PriceDisplayPanel() {
        displayLabel = new JLabel("0");
        add(displayLabel);
    }

    public JLabel getDisplayLabel() {
        return displayLabel;
    }
}
