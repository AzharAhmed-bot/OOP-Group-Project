import java.util.ArrayList;

public class ArithmeticFunction implements ArithmeticInterface {
    // Instance variables to store the numbers and operation sign

    private final ArrayList<Double> operands;
    private final ArrayList<String> operations;
    InputSection inputSection;

    // Constructor to initialize the numbers and operation sign
    public ArithmeticFunction(ArrayList<Double> operands, ArrayList<String> operations, InputSection inputSection) {
        this.operands = operands;
        this.operations = operations;
        this.inputSection = inputSection; 
    }
    

    // Method to perform addition
    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    // Method to perform subtraction
    @Override
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // Method to perform multiplication
    @Override
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    // Method to perform division
    @Override
    public double divide(double num1, double num2) {
        // Handling division by zero
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
            
        }
        return num1 / num2;
    }

    // Method to perform the arithmetic operation based on the operations list
    public double performOperation() {
        // Initialize result variable
        double result = operands.get(0);
        // Initialize a StringBuilder to build the operation string
        StringBuilder operationString = new StringBuilder();
    
        // Append the first operand
        operationString.append("[").append(operands.get(0)).append("]");
    
        // Iterate through operations and operands lists
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            double operand = operands.get(i + 1);
    
            // Append the operator and operand to the operation string
            operationString.append(" ").append(operation).append(" [").append(operand).append("]");
    
            // Perform the operation based on the sign
            switch (operation) {
                case "+":
                    result = add(result, operand);
                    break;
                case "-":
                    result = subtract(result, operand);
                    break;
                case "*":
                    result = multiply(result, operand);
                    break;
                case "/":
                    // Handle division by zero exception
                    if (operand == 0) {
                        // Print error message
                        System.out.println("Error: Cannot divide by zero");
                        return Double.NaN; // Return NaN (Not a Number) to indicate an invalid result
                    } else {
                        result = divide(result, operand);
                    }
                    break;
                default:
                    // Throw exception for invalid operation sign
                    throw new IllegalArgumentException("Invalid operation sign: " + operation);
            }
    
            // Update inputSection with the latest result
            inputSection.setInputField(String.valueOf(result));
        }
    
        // Print the operation and its result
        System.out.println("Performing operation: " + operationString.toString() + " = " + result);
        if (result == Math.floor(result)) {
            // If the result is a whole number, convert it to an integer
            int intValue = (int) result;
            return intValue;
        } else {
            // If the result is not a whole number, return it as a double
            return result;
        }
    }
    

}
