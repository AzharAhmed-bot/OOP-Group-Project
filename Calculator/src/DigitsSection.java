import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.regex.*;




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
                            String[] split = input.split("(?=[-+*/()])|(?<=[-+*/()])");
                            ArrayList<Double> operandsList = new ArrayList<>();
                            ArrayList<String> operationsList = new ArrayList<>();

                            for (String token : split) {                 
                                try {
                                    if (token.matches("sin\\d*|cos\\d*|tan\\d*|log\\d*|ln\\d*")) {
                                    // Extract numeric part from the token
                                    String functionName=token.substring(0,3).trim();
                                    String numericPart = token.substring(3).trim(); 
                                    double numericValue =Double.parseDouble(numericPart);
                                    double number=performScientificAction(functionName,numericValue,inputSection);
                                    operandsList.add(number);
                                }
                            
                                double number = Double.parseDouble(token);
                                operandsList.add(number);
                                    
                                } catch (NumberFormatException error) {
                                    if (token.equals("+")) {
                                        operationsList.add(token);
                                    }
                                    else if (token.equals("-")) {
                                        operationsList.add(token);
                                    }
                                    else if (token.equals("/")) {
                                        operationsList.add(token);
                                    }
                                    else if (token.equals("*")) {
                                        operationsList.add(token);
                                    }
                                 
                                    
                                }
                            }

                            ArithmeticFunction arithmeticFunction = new ArithmeticFunction(operandsList, operationsList,inputSection);
                            String result = arithmeticFunction.performOperation();
                            inputSection.setInputField(result);
                            
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
    private static double performScientificAction(String functionName, double numericValue, InputSection inputSection) {
        double result = 0;
        switch (functionName) {
            case "sin":
                // Perform sine operation
                ScientificFunction sinFunction = new ScientificFunction(numericValue, "sin", inputSection);
                result = sinFunction.sin();
                break;
            case "cos":
                // Perform cosine operation
                ScientificFunction cosFunction = new ScientificFunction(numericValue, "cos", inputSection);
                result = cosFunction.cos();
                break;
            case "tan":
                // Perform tangent operation
                ScientificFunction tanFunction = new ScientificFunction(numericValue, "tan", inputSection);
                result = tanFunction.tan();
                break;
            case "log":
                // Perform logarithm operation
                ScientificFunction logFunction = new ScientificFunction(numericValue, "log", inputSection);
                result = logFunction.log();
                break;
            case "ln":
                // Perform natural logarithm operation
                ScientificFunction lnFunction = new ScientificFunction(numericValue, "ln", inputSection);
                result = lnFunction.ln();
                break;
            default:
                // Handle invalid function name
                throw new IllegalArgumentException("Unsupported scientific function: " + functionName);
        }
        return result;
    }
    
}