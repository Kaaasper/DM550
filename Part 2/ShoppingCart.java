import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {

    // Class attributes
    private ArrayList<Product> cart;

    private static int howMany = 0;
    private static double mostExpensive = Double.NEGATIVE_INFINITY;
    private static ShoppingCart last = null;

    // Constructor
    public ShoppingCart() {
        this.cart = new ArrayList<>();
        howMany++;
        last = this;
    }

    public void add(Product product) {
        this.cart.add(product);
        if (this.totalPrice() > mostExpensive){
            mostExpensive = this.totalPrice();
        }
    }

    public int numberOfItems() {
        return this.cart.size();
    }

    public boolean freeDelivery() {
        return (numberOfItems() > 50);
    }

    public double totalPrice() {

        double total = 0;
        for (int i = 0; i < this.cart.size(); i++) {
            total = total + this.cart.get(i).price();
        }

        return total;

    }

    public Product mostExpensive() {
        Product expensive = null;

        double price = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < this.cart.size(); i++) {
            if (this.cart.get(i).price() > price){
                expensive = this.cart.get(i);
            }
        }

        return expensive;

    }

    public double highestPrice() {
        return mostExpensive().price();
    }

    public int howMany(Product product) {
        int count = 0;

        for (int i = 0; i < this.cart.size(); i++) {
            if (product.equals(this.cart.get(i))){
                count++;
            }
        }

        return count;

    }

    public void removeMostExpensive(){
        
        Product mE = mostExpensive();
        Product current;

        Iterator<Product> iter = cart.iterator();

        while (iter.hasNext()){
            current = iter.next();

            if (current.equals(mE)){
                iter.remove();
            }

        }




    }

    public static int howMany(){
        return howMany;
    }

    public static double mostExpensiveShoppingCart(){
        return mostExpensive;
    }

    public static ShoppingCart last(){
        return last;
    }
    

    public static void main(String[] args) {

        ShoppingCart s = new ShoppingCart();

        Product p = new Product("Ting", 2.5);

        System.out.println(p.hashCode());
        
        s.add(p);

        System.out.println(s.cart.size());

    }

}