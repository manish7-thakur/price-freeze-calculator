package com.agoda.pf.gui;

import javax.swing.*;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame(JPanel panel) {
        add(panel);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public static int DEFAULT_WIDTH = 300;
    public static int DEFAULT_HEIGHT = 400;
}
