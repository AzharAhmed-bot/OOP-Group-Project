import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ScientificSection extends JPanel implements ActionListener {
    JPanel panel;
    // JButton[] scientificButtons = new JButton[]{
    //     new JButton("("), new JButton(")"), new JButton("mc"), new JButton("m+"), new JButton("m-"),
    //     new JButton("mr"), new JButton("2nd"), new JButton("x²"), new JButton("x³"), new JButton("X^y"),
    //     new JButton("e^x"), new JButton("10^x"), new JButton("1/x"), new JButton("√"), new JButton("3√"),
    //     new JButton("LN(x)"), new JButton("log"), new JButton("x!"), new JButton("sin"), new JButton("cos"),
    //     new JButton("tan"), new JButton("e"), new JButton("EE"), new JButton("Rad"), new JButton("sinh"),
    //     new JButton("cosh"), new JButton("tanh"), new JButton("\u03C0"), new JButton("rand")
    // };

    public ScientificSection() {
    
        // for (JButton button : scientificButtons) {
        //     button.addActionListener(this);
        //     button.setFont(new Font("Poppins",Font.PLAIN,30));
        //     button.setFocusable(false);
        // }

        panel=new JPanel();
        panel.setLayout(new GridLayout(4,4,200,200));
        panel.setBackground(Color.GRAY);

        add(panel);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button click events here
    }
}
