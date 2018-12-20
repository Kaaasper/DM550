public class Fraction{

    //Class Attributes
    private int numerator, denominator;

    //Constructors
    public Fraction(){
        this.numerator = 1;
        this.denominator = 1;
    }

    public Fraction(int n){
        this.numerator = n;
        this.denominator = 1;
    }

    public Fraction(int n, int m){
        this.numerator = n;
        this.denominator = m;
    }

    //Getters and Setters
    public int getNumerator(){
        return this.numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    public void setNumerator(int n){
        this.numerator = n;
    }

    public void setDenominator(int d){
        this.denominator = d;
    }



    private static int gcd(int m, int n){
        while (m != n){
            if (m > n){
                m = m-n;
            } else {
                n = n-m;
            }
        }
        return m;
    }

    private static int lcm(int m, int n){
        return m/gcd(m, n) * n;
    }

    

    public Fraction add(Fraction f){
        //Calculate the numerators for each fraction
        int num1 = this.numerator * f.denominator;
        int num2 = this.denominator * f.numerator;

        int newNum = num1 + num2;

        //Calculate the new denominator
        int newDenom = this.denominator * f.denominator;

        int gcd = gcd(newNum,  newDenom);

        return new Fraction(newNum/gcd, newDenom/gcd);
    }
    
    public Fraction subtract(Fraction f){
        //Calculate the numerators for each fraction
        int num1 = this.numerator * f.denominator;
        int num2 = this.denominator * f.numerator;

        int newNum = num1 - num2;

        //Calculate the new denominator
        int newDenom = this.denominator * f.denominator;

        int gcd = gcd(newNum,  newDenom);

        return new Fraction(newNum/gcd, newDenom/gcd);

    }

    public Fraction multiply(Fraction f){
        int newNum = this.numerator * f.numerator;
        int newDenom = this.denominator * f.denominator;

        int gcd = gcd(newNum, newDenom);

        return new Fraction(newNum/gcd, newDenom/gcd);
    }

    public Fraction divide(Fraction f){
        int newNum = this.numerator * f.denominator;
        int newDenom = this.denominator * f.numerator;

        int gcd = gcd(newNum, newDenom);

        return new Fraction(newNum/gcd, newDenom/gcd);
        

    }

    public double value(){

        return this.numerator/(double) this.denominator;

    }

    public int integerPart(){
        return this.numerator/this.denominator;
    }

    public Fraction properPart(){
        return new Fraction(this.numerator%this.denominator, this.denominator);
    }

    public boolean equals(Object obj){
        if (!(obj instanceof Fraction)){
            return false;
        }

        Fraction other = (Fraction) obj;
        return (this.numerator * other.numerator == this.denominator*other.denominator);
    }

    public Fraction copy(){
        Fraction copy = new Fraction(this.numerator, this.denominator);
        return copy;

    }

    public String toString(){
        return ""+numerator+"/"+denominator;
    }


}