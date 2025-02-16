import java.text.*;

/**
 * Each product has a name, stock and price.
 *
 * You can sell and restock a product.
 */
public class Product {
    // insert 3 fields here
    private String name;
    private int stock;
    private double price;
    // insert 1 constructor here
    public Product(String name, int stock, double price){
        this.name = name;
        this.stock = stock;
        this.price = price;
    }
    /**
     * This pseudo-procedure sells "n" amount of stock.
     * The stock should decrease by "n".
     *
     * This method also returns the money earned from the sale.
     *
     * This is a rare occasion where a procedure returns something.
     */
    public double sell(int n) { // n = number
        // insert your code here to update the stock
        stock -= n;
        double money = n * price;
        return money; // a dummy return value - which you will change
    }
    
    public boolean has(int n){
        return n <= this.stock; // n is less than the amount of stock!! (e.g. 10 <= 200)
    }
    
    /**
     * Add "n" amount to this product's stock.
     */
    public void restock(int n) {
        stock += n;
    }

    /**
     * Return a string in the form:
     *
     * [stock] [name] at $[price]
     *
     * e.g. "200 Sticky tape at $2.99"
     *
     * DO NOT hard code the data in this string
     * or you will be penalised for a spoof.
     */
    @Override
    public String toString() {
        return stock + " " + name + " at $" + price;
    }
}
