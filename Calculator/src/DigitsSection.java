import javax.swing.*;
import java.awt.*;

public class DigitsSection extends JPanel {
    Font myFont = new Font("Arial", Font.PLAIN, 30);
    ArithmeticFunction arithmeticFunction;  // Declare an instance of the ArithmeticFunction class
    ScientificFunction scientificFunction;  // Declare an instance of the ScientificFunction class
    InputSection inputSection; // Declare an instance of the InputSection class

    public DigitsSection(InputSection inputSection) {
        this.inputSection = inputSection;

        setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttonLabels = {"C", "+/-", "%", "/",
                                 "7", "8", "9", "*",
                                 "4", "5", "6", "-",
                                 "1", "2", "3", "+",
                                 "del", "0", ".", "="};

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(myFont);
            button.setForeground(Color.decode("#FFFFFF"));
            if (label.equals("C") || label.equals("+/-") || label.equals("%")) {
                button.setBackground(Color.decode("#454442"));
            } else if (label.equals("/") || label.equals("*") || label.equals("-") || label.equals("+") || label.equals("=")) {
                button.setBackground(Color.decode("#FF9F09"));
            } else {
                button.setBackground(Color.decode("#636361"));
            }

            button.addActionListener(e -> {
                String buttonText = button.getText();
                if (buttonText.equals("C")) {
                    inputSection.deleteInputField();
                } else if (buttonText.equals("del")) {
                    inputSection.removeCurrentText();
                } else if (buttonText.equals("=")) {
                    // When "=" button is pressed, perform the calculation
                    String input = inputSection.getInputFieldText();
                    char sign = extractSign(input);
                    String[] operands = input.split("[" + sign + "]");
                    double num1 = Double.parseDouble(operands[0]);
                    double num2 = Double.parseDouble(operands[1]);
                    arithmeticFunction = new ArithmeticFunction(num1, String.valueOf(sign), num2);
                    double result = arithmeticFunction.performOperation();
                    inputSection.setInputField(String.valueOf(result));

                    applyScientificFunctions();
                }
                // Special case for the % symbol
                else if (buttonText.equals("%")) {
                    String input = inputSection.getInputFieldText();
                    char sign = extractSign(input);
                    String[] operands = input.split("[" + sign + "]");
                    double num = Double.parseDouble(operands[0]);
                    double result = num / 100.0;
                    inputSection.setInputField(String.valueOf(result));

                    // applyScientificFunctions();
                }
                // 2nd Special case for the symbol x/y
                else if (buttonText.equals("+/-")) {
                    // Handle the special case for changing the sign of the number
                    String input = inputSection.getInputFieldText();
                    double number = Double.parseDouble(input);
                    double result = number * -1; // Change the sign of the number
                    inputSection.setInputField(String.valueOf(result));

                    applyScientificFunctions();
                } else {
                    inputSection.updateInputField(buttonText);
                }
            });
            add(button);
        }
    }

    // Method to extract the sign from the input string
    private char extractSign(String input) {
        char sign = ' '; // Default sign
        for (char c : input.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
                sign = c;
                break; // Break once the sign is found
            }
        }
        return sign;
    }

    private void applyScientificFunctions() {
        String inputText = inputSection.getInputFieldText();
        double result = 0;
    
        if (inputText.startsWith("sin")) {
            String numericPart = inputText.substring(3); // Extract numeric part after "sin"
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "sin");
            result = scientificFunction.sin();
        } else if (inputText.startsWith("cos")) {
            String numericPart = inputText.substring(3); // Extract numeric part after "cos"
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "cos");
            result = scientificFunction.cos();
        } else if (inputText.startsWith("tan")) {
            String numericPart = inputText.substring(3); // Extract numeric part after "tan"
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "tan");
            result = scientificFunction.tan();
        } else if (inputText.startsWith("sinh")) {
            String numericPart = inputText.substring(4); // Extract numeric part after "sinh"
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "sinh");
            result = scientificFunction.sinH();
        } else if (inputText.startsWith("cosh")) {
            String numericPart = inputText.substring(4); // Extract numeric part after "cosh"
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "cosh");
            result = scientificFunction.cosH();
        } else if (inputText.startsWith("tanh")) {
            String numericPart = inputText.substring(4); // Extract numeric part after "tanh"
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "tanh");
            result = scientificFunction.tanH();
        }
    
        inputSection.setInputField(String.valueOf(result)); // Update input field with the result
    }
    
}
