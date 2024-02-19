import javax.swing.*;
import java.awt.*;

public class ScientificSection extends JPanel {

    public ScientificSection() {
        setLayout(new GridLayout(5, 5, 5, 5));

        String[] scientificButtonLabels = {"(", ")", "mc", "m+", "m-",
                                            "mr", "2nd", "x²", "x³", "X^y",
                                            "e^x", "10^x", "1/x", "√", "3√","x√y",
                                            "LN(x)", "log", "x!", "sin", "cos",
                                            "tan", "e", "EE", "Rad", "sinh",
                                            "cosh", "tanh", "π", "rand"};

        for (String label : scientificButtonLabels) {
            JButton button = new JButton(label);
            button.setBackground(Color.decode("#454442"));
            button.setForeground(Color.decode("#FFFFFF"));
            button.addActionListener(e -> {
                // Handle scientific button actions here
            });
            add(button);
        }
    }
}
