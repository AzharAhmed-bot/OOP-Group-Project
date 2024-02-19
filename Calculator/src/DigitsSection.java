import javax.swing.*;
import java.awt.*;

public class DigitsSection extends JPanel {
    Font myFont = new Font("Arial", Font.PLAIN, 30);
    ArithmeticFunction arithmeticFunction; // Declare an instance of the ArithmeticFunction class

    public DigitsSection(InputSection inputSection) {

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
                    double num1 = Integer.parseInt(operands[0]);
                    double num2 = Integer.parseInt(operands[1]);
                    arithmeticFunction = new ArithmeticFunction(num1, String.valueOf(sign), num2);
                    double result = arithmeticFunction.performOperation();
                    inputSection.setInputField(String.valueOf(result));
                    
                } 
                //Special case for the % symbol
                else if(buttonText.equals("%")){
                    String input = inputSection.getInputFieldText();
                    char sign = extractSign(input);
                    String[] operands = input.split("[" + sign + "]");            
                    double num=Integer.parseInt(operands[0]);
                    double result= num / 100.0;
                    inputSection.setInputField(String.valueOf(result));
                    
                }
                // 2nd Special case for the symbol x/y
                else if (buttonText.equals("+/-")) {
                    // Handle the special case for changing the sign of the number
                    String input = inputSection.getInputFieldText();
                    double number = Double.parseDouble(input);
                    double result = number * -1; // Change the sign of the number
                    inputSection.setInputField(String.valueOf(result));
                }
                
                
                
                else {
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
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' ) {
                sign = c;
                break; // Break once the sign is found
            }
        }
        return sign;
    }
}
