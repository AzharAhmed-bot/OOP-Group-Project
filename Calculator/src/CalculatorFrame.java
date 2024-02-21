import java.awt.*;
import javax.swing.*;

public class CalculatorFrame extends JFrame {

    public CalculatorFrame(String name, int width, int height) {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        

        // Create the sections
        InputSection inputSection = new InputSection();
        ScientificSection scientificSection = new ScientificSection(inputSection);
        DigitsSection digitsSection = new DigitsSection(inputSection);

        // Set the preferred size of the InputSection
        inputSection.setPreferredSize(new Dimension(width, height / 5));

        // Create a main panel to hold all sections
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Add inputSection to the main panel at the top
        mainPanel.add(inputSection, BorderLayout.NORTH);

        // Create a panel to hold the scientific and digits sections side by side
        JPanel sectionsPanel = new JPanel(new GridLayout(1, 2));
        sectionsPanel.add(scientificSection);
        sectionsPanel.add(digitsSection);

        // Add the sectionsPanel to the main panel at the center
        mainPanel.add(sectionsPanel, BorderLayout.CENTER);

        // Set the content pane of the frame
        setContentPane(mainPanel);
    }


   


}
