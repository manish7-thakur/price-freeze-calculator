import com.agoda.pf.event.listener.InputChangeListener;
import com.agoda.pf.gui.CalculatorFrame;
import com.agoda.pf.gui.InputPanel;
import com.agoda.pf.gui.PriceDisplayPanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = setUpUI(new InputPanel(), new PriceDisplayPanel());
            frame.setVisible(true);
        });
    }

    public static JFrame setUpUI(InputPanel inputPanel, PriceDisplayPanel displayPanel) {
        inputPanel.addInputChangeListeners(new InputChangeListener(displayPanel.getDisplayLabel()));
        JFrame frame = new CalculatorFrame(inputPanel, displayPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("Agoda price freeze calculator beta 1.0");
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 4, Toolkit.getDefaultToolkit().getScreenSize().height / 5);
        return frame;
    }
}
