import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends Abstract {
    InputSection inputSection;
    ScientificSection scientificSection;
    DigitsSection digitsSection;

    JFrame frame;

    public CalculatorFrame(String name, int width, int height) {
        super(name, width, height);
        // Frame section
        frame = new JFrame(this.name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create input section
        inputSection = new InputSection();
        // Create scientific section
        scientificSection = new ScientificSection();

        // Create buttons panel
        digitsSection=new DigitsSection();

        // Set layout to BorderLayout
        frame.setLayout(new BorderLayout());
        // Add input section to the top
        frame.add(inputSection, BorderLayout.NORTH);
        // Add scientific section to the WEST
        frame.add(scientificSection, BorderLayout.WEST);
        // Add buttons panel to the CENTER
        // frame.add(buttonsPanel, BorderLayout.CENTER);

        // Set preferred size for scientific section
        scientificSection.setPreferredSize(new Dimension(width / 2, height));

        // Set preferred size for buttons panel
        // digitsSection.setPreferredSize(new Dimension(width / 2, height));

        // Pack the frame to adjust sizes of components
        frame.pack();
        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        // Make the frame visible
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
