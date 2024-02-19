public class ScientificFunction extends ScientificAbstract {

    public ScientificFunction(double num, String sign) {
        super(num, sign);
    }

    @Override
    double square() {
        return num * num;
    }

    @Override
    double cube() {
        return num * num * num;
    }

    @Override
    double customPower(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    @Override
    double tenthPower() {
        return Math.pow(10, num);
    }

    @Override
    double fraction() {
        return 1 / num;
    }

    @Override
    double exponential() {
        return 2.718281828459045;
    }

    @Override
    double sqroot() {
        return Math.sqrt(num);
    }

    @Override
    double cubeRoot() {
        return Math.cbrt(num);
    }

    @Override
    double customRoot(double base, double exponent) {
        return Math.pow(base, 1.0 / exponent);
    }

    @Override
    double ln() {
        return Math.log(num);
    }

    @Override
    double log() {
        return Math.log10(num);
    }

    @Override
    double factorial() {
        if (num < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        double result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    @Override
    double sin() {
        double resultInRadians = degreeToRadian(num);
        return Math.sin(resultInRadians);
    }

    @Override
    double cos() {
        
        double resultInRadians = degreeToRadian(num);
        return Math.cos(resultInRadians);
    }

    @Override
    double tan() {
        double resultInRadians = degreeToRadian(num);
        return Math.tan(resultInRadians);
    }

    @Override
    double sinH() {
        double resultInDegrees = Math.toDegrees(Math.sinh(num));
        return resultInDegrees;
    }

    @Override
    double cosH() {
        double resultInDegrees = Math.toDegrees(Math.cosh(num));
        return resultInDegrees;
    }

    @Override
    double tanH() {
        double resultInDegrees = Math.toDegrees(Math.tanh(num));
        return resultInDegrees;
    }

    @Override
    double singleE() {
        return 2.718281828459045; 
    }

    @Override
    double doubleE() {
       
        return 0; 
    }

    @Override
    double rad() {
        return Math.toRadians(num);
    }

    @Override
    double rand() {
     
        return 0; 
    }

    public double degreeToRadian(double num) {
        double result = (num * Math.PI) / 180;
        return result;
    }
}
