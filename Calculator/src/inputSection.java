import javax.swing.*;
import java.awt.*;

public class inputSection extends JPanel {

    private final JTextField inputField;

    public inputSection() {
        setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setEditable(false);
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);
        inputField.setFont(new Font("Arial", Font.PLAIN, 24));
        inputField.setBackground(Color.decode("#32322F"));
        add(inputField, BorderLayout.CENTER);
    }

    public void updateInputField(String text) {
        String currentText = inputField.getText();
        if (currentText.equals("0")) {
            inputField.setText(text);
        } else {
            inputField.setText(currentText + text);
        }
    }

    public void deleteInputField() {
        inputField.setText(""); // Set text to empty string to delete it
    }

    public void removeCurrentText(){
        String currentText=inputField.getText();
        if(!currentText.isEmpty()){
            inputField.setText(currentText.substring(0, currentText.length()-1));
        }
    }

    public void setInputField(String text){
        inputField.setText(text);
    }
}