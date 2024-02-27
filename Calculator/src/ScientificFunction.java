

public class ScientificFunction extends ScientificAbstract {
    InputSection inputSection;
    // Constructor
    public ScientificFunction(double num, String sign, InputSection inputSection) {
        super(num, sign);
        this.inputSection=inputSection;
    }

    // Method to calculate square of a number
    @Override
    double square() {
        return num * num;
    }

    // Method to calculate cube of a number
    @Override
    double cube() {
        return num * num * num;
    }

    // Method to calculate custom power of a number
    @Override
    double customPower(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Method to calculate tenth power of a number
    @Override
    double tenthPower() {
        return Math.pow(10, num);
    }

    // Method to calculate reciprocal of a number
    @Override
    double fraction() {
        return 1 / num;
    }

    // Method to return Euler's number (e)
    @Override
    double exponential() {
        return 2.718281828459045;
    }

    // Method to calculate exponential power
    @Override
    double exponentialPower() {
        return Math.pow(2.718281828459045, num);
    }

    // Method to calculate square root of a number
    @Override
    double sqroot() {
        return Math.sqrt(num);
    }

    // Method to calculate cube root of a number
    @Override
    double cubeRoot() {
        return Math.cbrt(num);
    }

    // Method to calculate custom root of a number
    @Override
    double customRoot(double base, double exponent) {
        return Math.pow(base, 1.0 / exponent);
    }

    // Method to calculate natural logarithm of a number
    @Override
    double ln() {
        return Math.log(num);
    }

    // Method to calculate base-10 logarithm of a number
    @Override
    double log() {
        return Math.log10(num);
    }

    // Method to calculate factorial of a number
    @Override
    double factorial() {
        if (num < 0) {
            inputSection.setInputField("NaN");
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        double result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    // Method to calculate sine of an angle in degrees
    @Override
    double sin() {
        double resultInRadians = degreeToRadian(num);
        return Math.sin(resultInRadians);
    }

    // Method to calculate cosine of an angle in degrees
    @Override
    double cos() {
        double resultInRadians = degreeToRadian(num);
        return Math.cos(resultInRadians);
    }

    // Method to calculate tangent of an angle in degrees
    @Override
    double tan() {
        if(num==90){
            return Double.NaN;
        }
        double resultInRadians = degreeToRadian(num);
        return Math.tan(resultInRadians);
    }

    @Override
    double arcSin(){
        double resultInRadians = degreeToRadian(num);
        return Math.asin(resultInRadians);
    }
    @Override
    double arcCos() {
        
        double resultInRadians=degreeToRadian(num);
        return Math.acos(resultInRadians);
    }
    @Override
    double arcTan() {
        double resultInRadians=degreeToRadian(num);
        return Math.atan(resultInRadians);
    }



    // Method to calculate hyperbolic sine of an angle in degrees
    @Override
    double sinH() {
        double resultInDegrees = Math.toDegrees(Math.sinh(num));
        return resultInDegrees;
    }

    // Method to calculate hyperbolic cosine of an angle in degrees
    @Override
    double cosH() {
        double resultInDegrees = Math.toDegrees(Math.cosh(num));
        return resultInDegrees;
    }

    // Method to calculate hyperbolic tangent of an angle in degrees
    @Override
    double tanH() {
        double resultInDegrees = Math.toDegrees(Math.tanh(num));
        return resultInDegrees;
    }

    @Override
    double arcTanH() {
        double resultInRadians=degreeToRadian(num);
        return inverse(resultInRadians, "atanh");
    }

    @Override
    double arcSinH() {
        double resultInRadians=degreeToRadian(num);
        return inverse(resultInRadians, "asinh");
    }
    @Override
    double arcCosH() {
        double resultInRadians=degreeToRadian(num);
        return inverse(resultInRadians, "atanh ");
    }

    // Method to return Euler's number (e)
    @Override
    double singleE() {
        return 2.718281828459045;
    }

    // Method to return double of Euler's number (e)
    @Override
    double doubleE() {
        return 0; // Not implemented
    }

    // Method to convert degrees to radians
    @Override
    double rad() {
        return Math.toRadians(num);
    }

    @Override
    double mc(){
        return inputSection.resetMemory();
    }

    @Override
    double mread(){
        return inputSection.getMemoryValue();
    }

    @Override
    double mplus(){
        return inputSection.setMemoryValue(num);
    }

    @Override
    double mminus(){ 
        return inputSection.subtractFromMemory(num);
    }

    // Method to generate a random number
    @Override
    double rand() {
        return 0; // Not implemented
    }

    // Method to convert degrees to radians
    public double degreeToRadian(double num) {
        double result = (num * Math.PI) / 180;
        return result;
    }

    public double inverse(double num, String type) {
        double result = 0;
        if (type.equals("asinh")) {
            result = Math.log(num + Math.sqrt((num * num) + 1));
        } else if (type.equals("acosh")) {
            result = Math.log(num + Math.sqrt((num * num) - 1));
        } else if (type.equals("atanh")) {
            result = 0.5 * Math.log((1 + num) / (1 - num));
        }
        return result;
    }
      
}
