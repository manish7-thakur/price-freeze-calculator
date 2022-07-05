import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;

class MainTest {
    @Test
    public void setUpUIComponents() {
        JFrame frame = Main.setUpUI();
        Assertions.assertEquals(3, frame.getDefaultCloseOperation());
    }
}