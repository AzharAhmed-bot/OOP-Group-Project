import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DigitsSection implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton decButton ;
    JPanel panel;

    Font myFont = new Font("Calibri Light", Font.PLAIN, 17);

    DigitsSection(){

        //Creating the JFrame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        //creating the textfield
        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        // Creating button for decimal
        decButton = new JButton(".");
        decButton.addActionListener(this);
        decButton.setFont(myFont);
        decButton.setFocusable(false);
        decButton.setBackground(Color.BLACK);

        //Creating number buttons and setting ActionListener, font, and focusable(false)
        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            // setting the background color of the buttons to black
            numberButtons[i].setBackground(Color.BLACK);
        }

        // creating the panel and adding buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 3, 10, 10));

        // Adding number buttons to the panel
        for(int i = 1; i <= 9; i++) {
            panel.add(numberButtons[i]);
        }
        // Adding the zero button separately
        panel.add(numberButtons[0]);
        panel.add(decButton);

        //Adding components to the frame
        frame.add(panel);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //creating an instance of the DigitsSection class
        DigitsSection digitSec = new DigitsSection();
    }

    public void actionPerformed(ActionEvent e) {

        // Handling button clicks

        // If a number button is clicked , append the number to the textfield
        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        // If the decimal button is clicked, append "." to the textfield
        if(e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
    }
}
