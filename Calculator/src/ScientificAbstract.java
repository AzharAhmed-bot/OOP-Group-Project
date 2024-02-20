public abstract class ScientificAbstract{
   protected double num;
   protected String sign;
   
   public ScientificAbstract(double num,String sign){
    this.num=num;
    this.sign=sign;
   }
   //The abstract for scientific calculations
    abstract double square();
    abstract double cube();
    abstract double customPower(double num1, double num2);
    abstract double tenthPower();
    abstract double fraction();
    abstract double exponential();
    abstract double exponentialPower();
    abstract double sqroot();
    abstract double cubeRoot();
    abstract double customRoot(double num1, double num2);
    abstract double ln();
    abstract double log();
    abstract double factorial();
    abstract double sin();
    abstract double cos();
    abstract double tan();
    abstract double arcSin();
    abstract double arcCos();
    abstract double arcTan();
    abstract double singleE();
    abstract double doubleE();
    abstract double rad();
    abstract double sinH();
    abstract double cosH();
    abstract double tanH();
    abstract double rand();
    abstract double arcSinH();
    abstract double arcCosH();
    abstract double arcTanH();


}