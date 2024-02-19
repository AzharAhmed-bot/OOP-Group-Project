public class ArithmeticFunction implements ArithmeticInterface {
    private final double num1;
    private final double num2;
    private final String sign;
    InputSection inputField = new InputSection();

    public ArithmeticFunction(double num1, String sign, double num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.sign = sign;
    }

    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double divide(double num1, double num2) {
    if (num2 == 0) {
        throw new ArithmeticException("Cannot divide by zero");
    }
    return num1 / num2;
    }


    public double performOperation() {
        double result = 0; // initialize result variable
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
                try {
                    result = divide(num1, num2);
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operation sign: " + sign);
        }
        System.out.println("Performing operation: " + num1 + " " + sign + " " + num2 + " = " + result);
        return result;
    }
    
}
