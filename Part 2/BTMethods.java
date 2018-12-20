import java.util.ArrayList;
import java.util.Arrays;

public class BTMethods {

    public static void main(String[] args) {
        BinaryTree<Double> dT = new BinaryTree<Double>();
        dT.add(1.0);
        dT.add(2.0);
        dT.add(3.0);
        dT.add(7.0);

        // System.out.println(sum(dT));

        BinaryTree<Integer> iT = new BinaryTree<Integer>();
        iT.add(1);
        iT.add(3);
        iT.add(6);
        iT.add(0);
        iT.add(10);
        iT.add(0);

        // System.out.println(zeroes(iT));

        BinaryTree<String> sT = new BinaryTree<String>();
        sT.add("Hej");
        sT.add("Med");
        sT.add("Dig");
        sT.add("Hej igen");
        sT.add("Hej");

        // System.out.println(count(sT, "Hej"));

        // System.out.println(Arrays.toString(toArrayList(iT).toArray()));

        // System.out.println(Arrays.toString(selectLarger(iT, 2).toArray()));

        System.out.println(mostLeftTurns(iT));
        
    }

    /**
     * Task 1 - Compute sum of all values in t
     */
    public static double sum(BinaryTree<Double> t) {

        if (t.isEmpty()) {
            return 0;
        }

        return t.root() + sum(t.left()) + sum(t.right());

    }

    /**
     * Task 2 - Count number of zeroes in t
     */
    public static int zeroes(BinaryTree<Integer> t) {

        int z = 0;
        if (t.isEmpty()) {
            return 0;
        }
        if (t.root() == 0) {
            z = 1;
        }
        return z + zeroes(t.left()) + zeroes(t.right());

    }

    /**
     * Task 3 - Count number of occurences of s in t
     */
    public static int count(BinaryTree<String> t, String s) {

        int c = 0;
        if (t.isEmpty()) {
            return 0;
        }
        if (t.root().equals(s)) {
            c = 1;
        }
        return c + count(t.left(), s) + count(t.right(), s);

    }

    /**
     * Task 4 - Return list of all things in t, order not important
     */
    public static ArrayList<Integer> toArrayList(BinaryTree<Integer> t) {

        if (t.isEmpty()) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> bTList = new ArrayList<>();
        bTList.add(t.root());
        bTList.addAll(toArrayList(t.left()));
        bTList.addAll(toArrayList(t.right()));

        return bTList;

    }

    /**
     * Task 5 - Return list of elements in t larger than n
     */
    public static ArrayList<Integer> selectLarger(BinaryTree<Integer> t, int n) {

        if (t.isEmpty()) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> largerList = new ArrayList<Integer>();

        if (t.root() > n) {
            largerList.add(t.root());
        }

        largerList.addAll(selectLarger(t.left(), n));
        largerList.addAll(selectLarger(t.right(), n));

        return largerList;

    }

    /**
     * Task 6 - Returns highest number of left children
     */
    public static <E> int mostLeftTurns(BinaryTree<E> t){

        if (t.isEmpty()){
            return 0;
        }

        int left = 1 + mostLeftTurns(t.left());
        
        return Math.max(left, mostLeftTurns(t.right()));

        
        
        
    }
}