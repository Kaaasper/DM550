//File to test arrays
public class ArrayTests{

    public static void main(String[] args){
        double total = 0;
        double max;
        //Defining list
        double[] myList = {1.9, 2.9, 3.4, 3.5};
        
        //Printing elements in list
        for (int i = 0; i < myList.length; i++) {
            System.out.println(myList[i]);
        }   

        //Sum elements in array
        for (int j = 0; j < myList.length; j++) {
            total = total + myList[j];
        }

        System.out.println("Total sum of elements: " + total);

        max = myList[0];

        for (int n = 0; n < myList.length; n++) {
            if (myList[n] > max){
                max = myList[n];
            }
        }

        System.out.println("Maximum value in array: " + max);

        //Passing arrays to methods/functions
        printArray(myList);

        //Returning array from methods/functions
        printArray(reverseArray(myList));

    }


    public static void printArray(double[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1){
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");        
            }
        }
    }

    public static double[] reverseArray(double[] arr){
        double[] res = new double[arr.length];
        int j = arr.length-1;
        
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[j];
            j--;
        }

        return res;
    }

}
