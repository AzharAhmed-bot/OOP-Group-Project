import java.awt.*;
import javax.swing.*;

public class ScientificSection extends JPanel {
    JButton[] scientificButtons = new JButton[]{
        new JButton("("), new JButton(")"), new JButton("mc"), new JButton("m+"), new JButton("m-"),
        new JButton("mr"), new JButton("2nd"), new JButton("x²"), new JButton("x³"), new JButton("X^y"),
        new JButton("e^x"), new JButton("10^x"), new JButton("1/x"), new JButton("√"), new JButton("3√"),
        new JButton("LN(x)"), new JButton("log"), new JButton("x!"), new JButton("sin"), new JButton("cos"),
        new JButton("tan"), new JButton("e"), new JButton("EE"), new JButton("Rad"), new JButton("sinh"),
        new JButton("cosh"), new JButton("tanh"), new JButton("\u03C0"), new JButton("rand")
    };

    public ScientificSection() {
       
        setLayout(new GridLayout(5, 6, 5, 5)); // Set grid layout

        for (JButton button : scientificButtons) {
            button.setBackground(Color.GRAY);
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Poppins", Font.PLAIN, 16)); // Adjust font size
            button.setFocusable(false);
            
    
            add(button); // Add buttons to the panel
            
        }
    }
}
