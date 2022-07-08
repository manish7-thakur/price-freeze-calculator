import com.agoda.pf.gui.CalculatorFrame;
import com.agoda.pf.gui.InputPanel;
import com.agoda.pf.gui.PriceDisplayPanel;

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
        JFrame frame = new CalculatorFrame(new InputPanel(), new PriceDisplayPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
//        frame.setResizable(false);
        frame.pack();
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 4, Toolkit.getDefaultToolkit().getScreenSize().height / 5);
        return frame;
    }
}
