import java.util.ArrayList;

public class ArithmeticFunction implements ArithmeticInterface {
    // Instance variables to store the numbers and operation sign
    private final ArrayList<Double> operands;
    private final ArrayList<String> operations;
    InputSection inputSection;

    // Constructor to initialize the numbers and operation sign
    public ArithmeticFunction(ArrayList<Double> operands, ArrayList<String> operations) {
        this.operands = operands;
        this.operations = operations;
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
            inputSection.setInputField("NaN");
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }

    // Method to perform the arithmetic operation based on the operations list
    public String performOperation() {
        // Initialize result variable
        double result = operands.get(0);
        StringBuilder operationString = new StringBuilder("[").append(operands.get(0)).append("]");
        // Iterate through operations and operands lists
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            // Ensure that there are enough operands in the list
            double operand = operands.get(i + 1);
            operationString.append(" ").append(operation).append(" [").append(operand).append("]");

            // Perform the operation based on the sign
            switch (operation) {
                case "/":
                    result = divide(result, operand);
                    break;
                case "*":
                    result = multiply(result, operand);
                    break;
                case "+":
                    result = add(result, operand);
                    break;
                case "-":
                    result = subtract(result, operand);
                    break;
                default:
                    // Throw exception for invalid operation sign
                    throw new IllegalArgumentException("Invalid operation sign: " + operation);
            }
        }
        // Check if the result is a whole number
        if (result % 1 == 0) {
            // If it's a whole number, convert it to an integer
            System.out.println("Performing operation: " + operationString + " = " + result);
            return String.valueOf((int) result);
        } else {
            // If it's not a whole number, convert it to a string
            System.out.println("Performing operation: " + operationString + " = " + result);
            return String.valueOf(result);
        }
    }
}
