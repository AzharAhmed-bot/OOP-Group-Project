import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends Abstract {
    InputSection inputSection;
    JFrame frame;

    public CalculatorFrame(String name, int width, int height) {
        super(name, width, height);
        //Frame section
        frame = new JFrame(this.name);
        frame.setLayout(null); // Use null layout to manually set component positions
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(this.width, this.height);

        // Create input section
        inputSection = new InputSection();
        inputSection.setBounds(50,0,1200, 50); // Example bounds for input section
       

        frame.add(inputSection);

        //Digits section





        //Signs section

        frame.setVisible(true);
    }

    // Implement abstract methods
    @Override
    public void render() {
        // Render frame
    }

    @Override
    public void onClick() {
        // Handle click event
    }
}
