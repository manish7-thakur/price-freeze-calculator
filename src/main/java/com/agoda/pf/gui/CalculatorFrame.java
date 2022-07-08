package com.agoda.pf.gui;

import javax.swing.*;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame(JPanel inputPanel, JPanel displayPanel) {
        add(inputPanel);
        add(displayPanel);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public static int DEFAULT_WIDTH = 300;
    public static int DEFAULT_HEIGHT = 400;
}
