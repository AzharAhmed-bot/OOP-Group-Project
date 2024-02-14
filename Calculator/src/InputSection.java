import javax.swing.*;

// InputSection class representing the input section
public class InputSection extends JPanel {

    JTextField inputField;

    // Constructor
    public InputSection(int width, int height) {
        setLayout(null); 

        inputField = new JTextField();
        inputField.setBounds(50, 25, width, height);

        add(inputField); // Add the JTextField to the InputSection panel
    }
}
