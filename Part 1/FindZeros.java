public class FindZeros{

    public static void main(String[] args){
        System.out.println("Smallest value to make f return 0: "+findZeros());

    }

    public static int findZeros(){
        int smallesValue = 0;
        while (f(smallesValue) != 0){
            smallesValue++;
        }

        return smallesValue;


    }


    private static int f(int n){
        return n*n;
    }

    // //Will never terminate with n >= 0 when testing using findZeros function
    // private static int f(int n){
    //     return n+1;
    // }
    
}