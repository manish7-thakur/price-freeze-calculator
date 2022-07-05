package com.agoda.pf.gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class CalculatorFrameTest {
    @Test
    public void containsPFPanel() {
        JPanel panel = new JPanel();
        JFrame pfFrame = new PFCalculatorFrame(panel);
        Assertions.assertEquals(pfFrame.getComponents().length, 1);
    }
}
