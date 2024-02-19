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
       
        return 1/num; 
    }

    @Override
    double exponential(){
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
        return Math.sin(num);
    }

    @Override
    double cos() {
        return Math.cos(num);
    }

    @Override
    double tan() {
        return Math.tan(num);
    }

    @Override
    double singleE() {
      
        return 2.718281828459045; // Placeholder, implement your logic here
    }

    @Override
    double doubleE() {
        // Implementation of doubleE method
        return 0; // Placeholder, implement your logic here
    }

    @Override
    double rad() {
        return Math.toRadians(num);
    }

    @Override
    double sinH() {
        return Math.sinh(num);
    }

    @Override
    double cosH() {
        return Math.cosh(num);
    }

    @Override
    double tanH() {
        return Math.tanh(num);
    }

    @Override
    double rand() {
        // Implementation of rand method
        return 0; // Placeholder, implement your logic here
    }
   


  
}


