package com.agoda.pf.gui;

import javax.swing.*;
import java.awt.*;

public class PriceDisplayPanel extends JPanel {
    private JLabel displayLabel;

    public PriceDisplayPanel() {
        setLayout(new BorderLayout());
        displayLabel = new JLabel("0", SwingConstants.CENTER);
        add(displayLabel);
    }

    public JLabel getDisplayLabel() {
        return displayLabel;
    }
}
