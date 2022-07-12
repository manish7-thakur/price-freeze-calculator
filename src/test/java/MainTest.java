import com.agoda.pf.event.listener.InputChangeListener;
import com.agoda.pf.gui.InputPanel;
import com.agoda.pf.gui.PriceDisplayPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MainTest {
    JFrame frame;
    InputPanel inputPanelSpy;

    @BeforeAll
    public void setUp() {
        inputPanelSpy = Mockito.spy(InputPanel.class);
        frame = Main.setUpUI(inputPanelSpy, new PriceDisplayPanel());
    }

    @Test
    public void setUpUIProperties() {
        Assertions.assertEquals(3, frame.getDefaultCloseOperation());
        Assertions.assertTrue(frame.getLocation().getX() > 0);
        Assertions.assertTrue(frame.getLocation().getY() > 0);
        Assertions.assertFalse(frame.isResizable());
        Assertions.assertEquals("Agoda price freeze calculator beta 1.0", frame.getTitle());
    }

    @Test
    public void setFrameSizeAppropriateToScreenSize() {
        Assertions.assertEquals(frame.getWidth(), Toolkit.getDefaultToolkit().getScreenSize().width / 4);
        Assertions.assertEquals(frame.getHeight(), Toolkit.getDefaultToolkit().getScreenSize().height / 5);
    }

    @Test
    public void wiresUpInputChangeListeners() {
        Mockito.verify(inputPanelSpy).addInputChangeListeners(Mockito.any(InputChangeListener.class));
    }
}