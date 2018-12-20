public class Bisection{

    public static void main(String[] args){
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double error = Double.parseDouble(args[2]);

        if (f(a) * f(b) >= 0){
            System.out.println("Cannot compute the bisection method of the given values");
            System.exit(0);
        }

        System.out.println("Approximate solution using the bisection method: "+bisection(a, b, error));

    }

    //Overwrites the values of a and b
    public static double bisection(double a, double b, double error){

        double c;

        while (a-b >= error){
            c = (a+b)/2;
            if (f(a) * f(c) < 0){
                b = c;
            } else {
                a = c;
            }
        }
        return a;

    }

    private static double f(double x){
        return x*x-2*x-7;
    }

}