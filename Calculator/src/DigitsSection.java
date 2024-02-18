import java.awt.*;
import javax.swing.*;

public class DigitsSection extends JPanel {
    
     JButton[] digitsButton=new JButton[]{
        new JButton("C"),new JButton("+/-"),new JButton("%"),
        new JButton("7"), new JButton("8"), new JButton("9"),
        new JButton("4"), new JButton("5"), new JButton("6"),
        new JButton("1"), new JButton("2"), new JButton("3"),
        new JButton("0"), new JButton(".")
     };

    public DigitsSection(){
        setLayout(new GridLayout(4,3,5,5));

        for(JButton button: digitsButton){
            button.setBackground(Color.GRAY);
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Poppins", Font.PLAIN, 16)); // Adjust font size
            button.setFocusable(false);

            if(button.getText().equals("0")){
                
            }
            add(button);
        }
    }
}
