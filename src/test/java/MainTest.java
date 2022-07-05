import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.swing.*;
import java.awt.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MainTest {
    JFrame frame;

    @BeforeAll
    public void setUp() {
        frame = Main.setUpUI();
    }

    @Test
    public void setUpUIComponents() {
        Assertions.assertEquals(3, frame.getDefaultCloseOperation());
        Assertions.assertTrue(frame.getLocation().getX() > 0);
        Assertions.assertTrue(frame.getLocation().getY() > 0);
        Assertions.assertFalse(frame.isResizable());
    }

    @Test
    public void setFrameSizeAppropriateToScreenSize() {
        Assertions.assertEquals(frame.getWidth(), Toolkit.getDefaultToolkit().getScreenSize().width / 4);
        Assertions.assertEquals(frame.getHeight(), Toolkit.getDefaultToolkit().getScreenSize().height / 5);
    }
}