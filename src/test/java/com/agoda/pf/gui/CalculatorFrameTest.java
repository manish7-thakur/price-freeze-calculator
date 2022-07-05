package com.agoda.pf.gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.swing.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorFrameTest {
    JPanel panel;
    JFrame pfFrame;

    @BeforeAll
    public void setUp() {
        panel = new JPanel();
        pfFrame = new PFCalculatorFrame(panel);
    }

    @Test
    public void containsPFPanel() {
        JFrame pfFrame = new PFCalculatorFrame(panel);
        Assertions.assertEquals(1, pfFrame.getComponents().length);
    }

    @Test
    public void setsDefaultWidthAndHeight() {
        Assertions.assertEquals(pfFrame.getWidth(), 300);
        Assertions.assertEquals(pfFrame.getHeight(), 400);
    }
}
