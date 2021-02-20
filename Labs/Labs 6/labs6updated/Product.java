import java.text.*;

/**
 * Each product has a name, stock and price.
 *
 * You can sell and restock a product.
 */
public class Product {
    private String name;
    private int stock;
    private double price;

    public Product(String name, int stock, double price){
        this.name = name;
        this.stock = stock;
        this.price = price;
    }
    
    public int readNumber(){
        System.out.print("Number: ");
        return In.nextInt();
    }
    
    public String readProduct() {
        System.out.print("Name: ");
        return In.nextLine();
    }
    
    public String getName(){
        return name;
    }
    
    /* Do not know how to make Store use this function to verify for more than 1
    public boolean hasProduct(String partialName) {
        return partialName.toLowerCase().contains(this.name.toLowerCase());
    }
    */

    /** 
     * This pseudo-procedure sells "n" amount of stock.
     * The stock should decrease by "n".
     *
     * This method also returns the money earned from the sale.
     *
     * This is a rare occasion where a procedure returns something.
     */
    public double sell(int n) {
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
    
    public int viewStock(){
        return stock;
    }
   
    @Override
    public String toString() {
        return name + " - " + stock + " at $" + formatted(price);
    }
    
    private String formatted(double amount) {
        return new DecimalFormat("###,##0.00").format(amount);
    }
}
