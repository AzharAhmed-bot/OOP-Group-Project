import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends Abstract {
    InputSection inputSection;
    ScientificSection scientificSection;

    JFrame frame;

    public CalculatorFrame(String name, int width, int height) {
        super(name, width, height);
        //Frame section
        frame = new JFrame(this.name);
        // To manually set components position
        frame.setLayout(null); 
        //To close the program when cross is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(this.width, this.height);

        // Create input section
        inputSection = new InputSection();
        inputSection.setBounds(50,0,1200, 50); 
        frame.add(inputSection);

        // Scientific section
        scientificSection= new ScientificSection();
        scientificSection.setBounds(50, 100, 300, 300);
        frame.add(scientificSection);
    
       

       

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
