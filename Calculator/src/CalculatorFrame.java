import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CalculatorFrame extends Abstract {

    JFrame Frame;
    public CalculatorFrame(String name, int width, int height) {
        super(name, width, height);

      Frame=new JFrame(this.name);
      Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Frame.setSize(this.width,this.height);
      Frame.setLayout(null);
      
    //   InputSection inputSection=new InputSection(300, 50);
      
    //   Frame.add(inputSection);

      Frame.setVisible(true);
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
