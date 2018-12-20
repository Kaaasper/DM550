public class Product{

    //Class Atrributes
    private String name;
    private double price;

    //Constructor
    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public double price(){
        return this.price;
    }

    public String name(){
        return this.name;
    }

    public boolean equals(Object other){
        if(!(other instanceof Product)){
            return false;
        }
        Product oP = (Product) other;
        
        return (this.name.equals(oP.name) && (this.price == oP.price));

    }

    public int hashCode(){
        int hash = 0;
        int i;

        for (i = 0; i < this.name.length(); i++){
            hash = hash + (int) (this.name.charAt(i) * Math.pow(31, i));
        }
        hash = hash + (int) (this.price * Math.pow(31, i));

        return hash;

    }

    
}