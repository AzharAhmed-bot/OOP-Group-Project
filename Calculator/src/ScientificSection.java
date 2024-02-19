import javax.swing.*;
import java.awt.*;

public class ScientificSection extends JPanel {
    Font myFont = new Font("Arial", Font.PLAIN, 30);
    InputSection inputSection;

    public ScientificSection(InputSection inputSection) {
        this.inputSection = inputSection;
        setLayout(new GridLayout(5, 5, 5, 5));

        String[] scientificButtonLabels = {"(", ")", "mc", "m+", "m-",
                "mr", "2nd", "x²", "x³", "X^y",
                "e^x", "10^x", "1/x", "√", "3√","x√y",
                "LN(x)", "log", "x!", "sin", "cos",
                "tan", "e", "EE", "Rad", "sinh",
                "cosh", "tanh", "π", "rand"};

        for (String label : scientificButtonLabels) {
            JButton button = new JButton(label);

            button.setFont(myFont);
            button.setBackground(Color.decode("#454442"));
            button.setForeground(Color.decode("#FFFFFF"));
            button.addActionListener(e -> {
                String buttonText = button.getText();
                switch (buttonText) {
                    case "x²":
                        applyUnaryFunction("square");
                        break;
                    case "x³":
                        applyUnaryFunction("cube");
                        break;
                    case "√":
                        applyUnaryFunction("sqroot");
                        break;
                    case "3√":
                        applyUnaryFunction("cubeRoot");
                    case "1/x":
                        applyUnaryFunction("fraction");
                    case "e":
                        double result=2.718281828459045;
                        inputSection.updateInputField(String.valueOf(result));
                        break;
                    case "LN(x)":
                        inputSection.updateInputField("ln");
    
                        break;
                    case "log":
                        inputSection.updateInputField(buttonText);
                        break;
                    case "x!":
                        applyUnaryFunction("factorial");
                        break;
                    case "sin":
                        inputSection.updateInputField(buttonText);
                        break;
                    case "cos":
                        inputSection.updateInputField(buttonText);
                        break;
                    case "tan":
                        inputSection.updateInputField(buttonText);
                        break;
                    case "tanh":
                        inputSection.updateInputField("tah");
                        break;
                    case "sinh":
                        inputSection.updateInputField("sih");
                        break;
                    case "cosh":
                        inputSection.updateInputField("coh");
                        break;
                    case "π":
                        double result2=Math.PI;
                        inputSection.setInputField(String.valueOf(result2));
                        break;
                    case "x√y":
                        inputSection.updateInputField("√");
                    case "X^y":
                        inputSection.updateInputField("^");
                    // Add cases for other scientific functions here


                    default:
                        break;
                }
            });
            add(button);
        }
    }

    private void applyUnaryFunction(String functionName) {
        double num = Double.parseDouble(inputSection.getInputFieldText());
        ScientificFunction scientificFunction = new ScientificFunction(num, functionName);
        double result = 0;
        switch (functionName) {
            case "square":
                result = scientificFunction.square();
                break;
            case "cube":
                result = scientificFunction.cube();
                break;
            case "sqroot":
                result = scientificFunction.sqroot();
                break;
            case "cubeRoot":
                result = scientificFunction.cubeRoot();
            case "fraction":
                result = scientificFunction.fraction();
                break;
            case "exponential":
                result=scientificFunction.exponential();
            case "factorial":
                result = scientificFunction.factorial();
                break;
            case "pi":
                result=Math.PI;
            default:
                break;
        }
        inputSection.setInputField(String.valueOf(result));
    }



   
     
}
