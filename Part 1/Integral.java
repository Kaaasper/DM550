public class Integral{

    /**
     * I do not know how to calculate the integral so this is Luis solution
     */
    public static void main(String[] args){
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        int intervals = Integer.parseInt(args[2]);

        System.out.println("Area under graph is approximately: "+calcIntegral(a, b, intervals));

    }
    

    public static double calcIntegral(double a, double b, double intervals){
        int i = 0;
        double increment = (b-a)/intervals;
        double integral = 0;
        while (i < intervals){
            integral = integral + rectangleArea(a+increment*intervals, a+increment*(intervals+1));
            i++;
        }
        return integral;

    }

    public static double rectangleArea(double a, double b){
        return (b-a)*f((a+b)/2);
    }

    private static double f(double x){
        return x*x+2*x+7;
    }
    
}