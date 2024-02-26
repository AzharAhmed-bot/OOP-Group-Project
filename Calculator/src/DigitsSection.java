import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.regex.Pattern;

class DigitsSection extends JPanel {
    // Font for the buttons
    Font myFont = new Font("Arial", Font.PLAIN, 30);
    // References to other sections
    ArithmeticFunction arithmeticFunction;
    ScientificFunction scientificFunction;
    InputSection inputSection;
    ArrayList<Double> operands = new ArrayList<>();
    ArrayList<String> operations = new ArrayList<>();

    // Constructor
    public DigitsSection(InputSection inputSection) {
        this.inputSection = inputSection;

        // Setting grid layout for the panel
        setLayout(new GridLayout(5, 4, 5, 5));

        // Button labels
        String[] buttonLabels = {"C", "+/-", "%", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "del", "0", ".", "="};

        // Creating buttons and setting properties
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(myFont);
            button.setForeground(Color.decode("#FFFFFF"));
            // Setting background colors based on button label
            if (label.equals("C") || label.equals("+/-") || label.equals("%")) {
                button.setBackground(Color.decode("#454442"));
            } else if (label.equals("/") || label.equals("*") || label.equals("-") || label.equals("+") || label.equals("=")) {
                button.setBackground(Color.decode("#FF9F09"));
            } else {
                button.setBackground(Color.decode("#636361"));
            }

            // Adding action listener to the button
            button.addActionListener(e -> {
                String buttonText = button.getText();
                // Handling different button actions
                if (buttonText.equals("C")) {
                    inputSection.deleteInputField();
                } else if (buttonText.equals("del")) {
                    inputSection.removeCurrentText();
                } else if (buttonText.equals("=")) {
                    // Handling evaluation
                    String input = inputSection.getInputFieldText();
                    char sign = extractSign(input);
                    if (sign == ' ') {
                        applyScientificFunctions();
                    } else {
                        // Splitting input based on operator
                        String[] operands = input.split(Pattern.quote(String.valueOf(sign)));
                        if (sign == '√') {
                            // Square root operation
                            double num1 = Double.parseDouble(operands[0]);
                            double num2 = Double.parseDouble(operands[1]);
                            ScientificFunction scientificFunction=new ScientificFunction(num1, "^",inputSection);
                            double result = scientificFunction.customRoot(num2, num1);
                            inputSection.setInputField(String.valueOf(result));
                        } else if (sign == '^') { // Check for '^' sign
                            // Exponential operation
                            double num1 = Double.parseDouble(operands[0]);
                            double num2 = Double.parseDouble(operands[1]);
                            ScientificFunction scientificFunction=new ScientificFunction(num1, "^",inputSection);
                            double result=scientificFunction.customPower(num1, num2);
                            inputSection.setInputField(String.valueOf(result));
                        } else if (sign == 'E') {
                            // Handling scientific notation
                            double num1 = Double.parseDouble(operands[0]);
                            double num2 = Double.parseDouble(operands[1]);
                            double result = num1 * (Math.pow(10, num2));
                            inputSection.setInputField(String.valueOf(result));
                        } else {
                            // Handling basic arithmetic operations
                            String[] split = input.split("(?<=(?<=sin|cos|tan|ln|log|√)\\d)(?=\\D)|(?<=\\D)(?=\\d)|(?<=sin|cos|tan|ln|log|√)");
                            ArrayList<Double> operandsList = new ArrayList<>();
                            ArrayList<String> operationsList = new ArrayList<>();
                            
                            for (String token : split) {
                                // double test=Double.parseDouble(operands[0]);
                                // System.out.print(test);
                                try {
                                   
                                        double number = Double.parseDouble(token);
                                        operandsList.add(number);
                                    }
                                    
                                 catch (NumberFormatException error) {
                                    
                                    if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
                                        operationsList.add(token); // Add arithmetic operation to operations list
                                    }
                                }
                            }

                            // Now you can continue with the normal arithmetic operation using operandsList and operationsList
                            ArithmeticFunction arithmeticFunction = new ArithmeticFunction(operandsList, operationsList, inputSection);
                            double result = arithmeticFunction.performOperation();
                            inputSection.setInputField(String.valueOf(result));

                        }
                    }
                } else if (buttonText.equals("%")) {
                    // Handling percentage calculation
                    String input = inputSection.getInputFieldText();
                    char sign = extractSign(input);
                    String[] operands = input.split("[" + sign + "]");
                    double num = Double.parseDouble(operands[0]);
                    double result = num / 100.0;
                    inputSection.setInputField(String.valueOf(result));
                } else if (buttonText.equals("+/-")) {
                    // Toggling positive/negative sign
                    String input = inputSection.getInputFieldText();
                    double number = Double.parseDouble(input);
                    double result = number * -1;
                    inputSection.setInputField(String.valueOf(result));
                } else {
                    // Updating input field with button text
                    inputSection.updateInputField(buttonText);
                }
            });
            // Adding button to the panel
            add(button);
        }
    }

    // Method to extract operator from input
    private char extractSign(String input) {
        String newInput = removeBrackets(input);
        System.out.println(newInput);
        char sign = ' ';
        for (char c : newInput.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '√' || c == '^' || c == 'E') {
                sign = c;
                break;
            }
        }
        return sign;
    }

    // Method to remove unnecessary characters from input
    public String removeBrackets(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            // Only append digits, decimal points, or valid mathematical symbols
            if (Character.isDigit(c) || c == '.' || c == '-' || c == '+' || c == '*' || c == '/' || c == '%' || c == '√' || c == '^' || c == 'E') {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Method to apply scientific functions
    private void applyScientificFunctions() {
        String inputText = inputSection.getInputFieldText();
        double result = 0;

        // Parsing numeric part and applying corresponding scientific function
        if (inputText.startsWith("sin")) {
            String numericPart = inputText.substring(3);
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "sin",inputSection);
            result = scientificFunction.sin();
        }else if(inputText.startsWith("arcSin")){
            String numericPart = inputText.substring(6);
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "arcSin",inputSection);
            result = scientificFunction.arcSin();
        }   else if (inputText.startsWith("cos")) {
            String numericPart = inputText.substring(3);
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "cos",inputSection);
            result = scientificFunction.cos();
        } else if(inputText.startsWith("arcCos")){
            String numericPart = inputText.substring(6);
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "sinh",inputSection);
            result = scientificFunction.arcCos();
        } else if (inputText.startsWith("tan")) {
            String numericPart = inputText.substring(3);
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "tan",inputSection);
            result = scientificFunction.tan();
        } else if(inputText.startsWith("arcTan")){
            String numericPart = inputText.substring(6);
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "arcTan",inputSection);
            result = scientificFunction.arcTan();
        } else if (inputText.startsWith("log")) {
            String numericPart = inputText.substring(3);
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "log",inputSection);
            result = scientificFunction.log();
        } else if (inputText.startsWith("ln")) {
            String numericPart = inputText.substring(3);
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "ln",inputSection);
            result = scientificFunction.ln();
        } else if (inputText.startsWith("sih")) {
            String numericPart = inputText.substring(3);
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "sinh",inputSection);
            result = scientificFunction.sinH();
        } else if (inputText.startsWith("arcSiH")) {
            String numericPart = inputText.substring(6);
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "arcSinh",inputSection);
            result = scientificFunction.arcSinH();
        }  else if (inputText.startsWith("coh")) {
            String numericPart = inputText.substring(3);
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "cosh",inputSection);
            result = scientificFunction.cosH();
        } else if (inputText.startsWith("arcCoH")) {
            String numericPart = inputText.substring(6);
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "arcCosh",inputSection);
            result = scientificFunction.arcCosH();
        } 
           else if (inputText.startsWith("tah")) {
            String numericPart = inputText.substring(3);
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "tanh",inputSection);
            result = scientificFunction.tanH();
        } else if (inputText.startsWith("arcTaH")) {
            String numericPart = inputText.substring(6);
            double num = Double.parseDouble(numericPart);
            scientificFunction = new ScientificFunction(num, "sinh",inputSection);
            result = scientificFunction.arcTanH();
        } 
         else if (inputText.startsWith("√")) {
            String numericPart = inputText.substring(1); // Extract numeric part after "√"
            double num = Double.parseDouble(numericPart);
            result = Math.sqrt(num);
        }

        // Updating input field with the result
        inputSection.setInputField(String.valueOf(result));
    }

    // private double performScientificFunction(String functionName, double number) {
    //     double result = 0;
    //     ScientificFunction scientificFunction;
    //     switch (functionName) {
    //         case "sin":
    //             scientificFunction = new ScientificFunction(number, "sin", inputSection);
    //             result = scientificFunction.sin();
    //             break;
    //         case "cos":
    //             scientificFunction = new ScientificFunction(number, "cos", inputSection);
    //             result = scientificFunction.cos();
    //             break;
    //         case "tan":
    //             scientificFunction = new ScientificFunction(number, "tan", inputSection);
    //             result = scientificFunction.tan();
    //             break;
    //         case "ln":
    //             scientificFunction = new ScientificFunction(number, "ln", inputSection);
    //             result = scientificFunction.ln();
    //             break;
    //         case "log":
    //             scientificFunction = new ScientificFunction(number, "log", inputSection);
    //             result = scientificFunction.log();
    //             break;
    //         case "√":
    //             result = Math.sqrt(number);
    //             break;
    //         default:
    //             // Handle unsupported scientific functions
    //             throw new IllegalArgumentException("Unsupported scientific function: " + functionName);
    //     }
    //     return result;
    // }
    
}
