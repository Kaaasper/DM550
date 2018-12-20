import java.util.ArrayList;
import java.util.Arrays;

public class TreeUtils {

    public static void main(String[] args) {
        BinaryTree<Double> dT = new BinaryTree<Double>();
        dT.add(0.0);
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

        // System.out.println(zeros(iT));

        BinaryTree<String> sT = new BinaryTree<String>();
        sT.add("Hej");
        sT.add("Med");
        sT.add("Dig");
        sT.add("Hej igen");
        sT.add("Hej");

        // System.out.println(count(sT, "Hej"));

        // for (int i : toArrayList(iT)) {
        //     System.out.println(i);
        // }

        // for (int i : selectLarger(iT, 2)) {
        // System.out.println(i);
        // }

        System.out.println(mostLeftTurns(iT));
        System.out.println(iT);

    }

    public static double sum(BinaryTree<Double> t) {
        if (t.isEmpty()) {
            return 0;
        }

        return t.root() + sum(t.left()) + sum(t.right());
    }

    public static int zeros(BinaryTree<Integer> t) {

        if (t.isEmpty()) {
            return 0;
        }

        if (t.root() == 0) {
            return 1 + zeros(t.left()) + zeros(t.right());
        }

        return zeros(t.left()) + zeros(t.right());

    }

    public static int count(BinaryTree<String> t, String s) {

        if (t.isEmpty()) {
            return 0;
        }
        int count = t.root().equals(s) ? 1 : 0;
        return count + count(t.left(), s) + count(t.right(), s);

    }

    public static ArrayList<Integer> toArrayList(BinaryTree<Integer> t) {
        if (t.isEmpty()) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(t.root());

        // for (int i : toArrayList(t.left())){
        // list.add(i);
        // }

        // for (int i : toArrayList(t.right())){
        // list.add(i);
        // }

        list.addAll(toArrayList(t.left()));
        list.addAll(toArrayList(t.right()));

        return list;

    }

    public static ArrayList<Integer> selectLarger(BinaryTree<Integer> t, int n) {
        ArrayList<Integer> list = new ArrayList<>();

        if (!(t.isEmpty())) {
            int root = t.root();
            if (root > n) {
                list.add(root);
            }

            list.addAll(selectLarger(t.left(), n));
            list.addAll(selectLarger(t.right(), n));

        }
        return list;
    }

    public static <E> int mostLeftTurns(BinaryTree<E> t) {
        if (t.isEmpty()){
            return 0;
        }

        int left = 1 + mostLeftTurns(t.left());
        return Math.max(left, mostLeftTurns(t.right()));

    }

}