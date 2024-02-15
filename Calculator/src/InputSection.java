import javax.swing.*;
import java.awt.*;

public class InputSection extends JPanel {
    JTextField inputField;

    public InputSection() {
        setLayout(new BorderLayout());

        // Create text field
        inputField = new JTextField();
        // inputField.setEnabled(false);
        

        // Set cursor alignment to right
        inputField.setHorizontalAlignment(SwingConstants.RIGHT); 

        inputField.setFont(new Font("Poppins", Font.PLAIN, 30));
        
    
        add(inputField, BorderLayout.CENTER);
    }
}
