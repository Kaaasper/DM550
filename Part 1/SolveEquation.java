public class SolveEquation{

    public static void main(String[] args){
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        int solutions = numberOfSolution(a, b, c);

        switch (solutions){
            case (0):
                System.out.println("No solutions");
                break;
            
            case (1):
                calcOneSolution(a, b, c);
                break;

            case (2):
                calcTwoSolutions(a, b, c);
                break;

        }


    }

    public static int numberOfSolution(double a, double b, double c){
        double res = b*b-4*a*c;
        if (res > 0){
            return 2;
        } else if (res == 0){
            return 1;
        } else {
            return 0;
        }
    }


    public static void calcOneSolution(double a, double b, double c){

        double x;
        x = -(b/2*a);
        System.out.println("One solution: "+x);

    }

    //This could also be done using a double[]
    public static void calcTwoSolutions(double a, double b, double c){
        double xPlus;
        double xMinus;

        xPlus = (-b+Math.sqrt(b*b-4*a*c))/2*a;

        xMinus = (-b-Math.sqrt(b*b-4*a*c))/2*a;

        System.out.println("Two solutoions, using plus: "+xPlus+", using minus: "+xMinus);

    }


}