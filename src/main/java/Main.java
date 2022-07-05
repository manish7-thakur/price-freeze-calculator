import com.agoda.pf.gui.PFCalculatorFrame;
import com.agoda.pf.gui.PFInputPanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = setUpUI();
            frame.setVisible(true);
        });
    }

    public static JFrame setUpUI() {
        JFrame frame = new PFCalculatorFrame(new PFInputPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        return frame;
    }
}
