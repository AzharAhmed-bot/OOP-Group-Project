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
            inputField.setInputField("Math Error");
        }
        return num1 / num2;
    }

    public double performOperation() {
        switch (sign) {
            case "+":
                return add(num1, num2);
            case "-":
                return subtract(num1, num2);
            case "*":
                return multiply(num1, num2);
            case "/":
                return divide(num1, num2);
            default:
                throw new IllegalArgumentException("Invalid operation sign: " + sign);
        }
    }
}
