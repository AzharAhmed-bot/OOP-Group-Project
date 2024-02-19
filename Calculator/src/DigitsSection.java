
import javax.swing.*;
import java.awt.*;

public class DigitsSection extends JPanel {

    public DigitsSection(InputSection inputSection) {
        setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttonLabels = {"C","+/-","%","/",
                                "7", "8", "9","*" ,
                                 "4", "5", "6", "-",
                                "1", "2", "3","+", 
                                "del",  "0", ".", "=", };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(e -> {
                String buttonText = button.getText();
                if(buttonText.equals("C")){
                    inputSection.deleteInputField();
                }
                else if(buttonText.equals("del")) {
                    inputSection.removeCurrentText();
                }
                else{
                inputSection.updateInputField(buttonText);
                }
            });
            add(button);
        }
    }
}
