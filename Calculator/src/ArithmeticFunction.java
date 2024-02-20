public class ArithmeticFunction implements ArithmeticInterface {
    // Instance variables to store the numbers and operation sign
    private final double num1;
    private final double num2;
    private final String sign;
    // Input section for potential error handling
    InputSection inputField = new InputSection();

    // Constructor to initialize the numbers and operation sign
    public ArithmeticFunction(double num1, String sign, double num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.sign = sign;
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

    // Method to perform the arithmetic operation based on the operation sign
    public double performOperation() {
        // Initialize result variable
        double result = 0; 
        // Perform the operation based on the sign
        switch (sign) {
            case "+":
                result = add(num1, num2);
                break;
            case "-":
                result = subtract(num1, num2);
                break;
            case "*":
                result = multiply(num1, num2);
                break;
            case "/":
                // Handle division by zero exception
                try {
                    result = divide(num1, num2);
                } catch (ArithmeticException e) {
                    // Print error message
                    System.out.println("Error: " + e.getMessage());
                    inputField.updateInputField(e.getMessage());
                }
                break;
            default:
                // Throw exception for invalid operation sign
                throw new IllegalArgumentException("Invalid operation sign: " + sign);

        }
        // Print the operation and its result
        System.out.println("Performing operation: " + num1 + " " + sign + " " + num2 + " = " + result);
        return result;
    }   
}
