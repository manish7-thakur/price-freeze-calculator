package com.agoda.pf.gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class PFInputPanelTest {
    @Test
    public void usesGridLayout() {
        JPanel panel = new PFInputPanel();
        Assertions.assertEquals("GridLayout", panel.getLayout().getClass().getSimpleName());
    }
}
