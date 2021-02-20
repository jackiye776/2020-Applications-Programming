import java.util.*;
    
public class Store {
    public static void main(String[] args){
        Store store = new Store();
        store.use();
    }
    // insert 2 fields here
    private LinkedList<Product> products = new LinkedList<Product>();
    private CashRegister cashRegister;
    // insert 1 constructor here
    public Store(){
        products.add(new Product("Whiteboard Marker", 85, 1.50));
        products.add(new Product("Whiteboard Eraser", 45, 5.00));
        products.add(new Product("Black Pen", 100, 1.50));
        products.add(new Product("Red Pen", 100, 1.50));
        products.add(new Product("Blue Pen", 100, 1.50));
        cashRegister = new CashRegister(0);
    }
    
    public void use() {
        char choice;
        while((choice = readChoice()) != 'x') {
            switch(choice) {
                case 's' : sell(); break;
                case 'r' : restock(); break;
                case 'v' : viewStock(); break;
                case 'c' : viewCash(); break;
                case 'p' : pruneProducts(); break;
                default: help(); break;
            }
        }
    }
    
    private char readChoice(){
        System.out.print("Choice (s/r/v/c/p/x): ");
        return In.nextChar();
    }
    
    private void sell() {
        String productName = readProduct();
        LinkedList<Product> item = products(productName);
        
        if (item.size() >= 2){
            System.out.println("Multiple products match:");
            for (Product product : item) {
                System.out.println(product);
            }
        }
        
        else if (item.size() == 1) {
            for (Product product : item){
                if (item.size() == 1 && product != null) {
                    System.out.println("Selling " + productName);
                    int number = product.readNumber();
                    if(product.has(number)){
                        double sale = product.sell(number);
                        cashRegister.add(sale);
                    }
                    else {
                        System.out.println("Not enough stock");
                    }
                }
            }
        }
        
        else if (item.size() == 0){
                System.out.println("No such product");
        }
    }
    
    private String readProduct() {
        System.out.print("Name: ");
        return In.nextLine();
    }
    
    private void restock() {
        String productName = readProduct();
        LinkedList<Product> item = products(productName);
        
        if (item.size() >= 1) {
            for (Product product : item){
                System.out.println("Restocking " + product.getName());
                int number = product.readNumber();
                product.restock(number);
            }
        }
        else {
            System.out.println("Adding new product");
            int number = readNumber();
            double price = readPrice();
            products.add(new Product(productName, number, price));
            
        }
    }
    
    private int readNumber() {
        System.out.print("Number: ");
        return In.nextInt();
    }
    
    private double readPrice() {
        System.out.print("Price: $");
        return In.nextDouble();
    }
    
    private void viewStock() {
        for (Product product : products)
        System.out.println(product);
    }
    
    private void viewCash() {
        System.out.println(cashRegister);
    }
        
    private void pruneProducts(){
        LinkedList<Product> productList = productList(products);
        products.removeAll(productList);
    }
    // Copying the original list into a new list called "matches"
    private LinkedList<Product> productList(LinkedList<Product> products){
        LinkedList<Product> matches = new LinkedList<Product>();
        for (Product product : products){
            if (product.viewStock() == 0) {
                matches.add(product); // if stock == 0, add the product to the new list
            }
        }
        return matches; // will be used in pruneProducts() method
    }
         
    // Lookup function
    /*
    private Product product(String name) {
        for (Product product : products)    
            if (product.hasProduct(name))
                return product;
        return null;
    }
    */
    private LinkedList<Product> products(String partialName){
        LinkedList<Product> matches = new LinkedList<Product>();
        for (Product product : products) 
            if (product.getName().toLowerCase().contains(partialName.toLowerCase())) {
                matches.add(product);
            }
        return matches;
        }
       
    private void help() {
        System.out.println("Menu options");
        System.out.println("s = sell");
        System.out.println("r = restock");
        System.out.println("v = view stock");
        System.out.println("c = view cash");
        System.out.println("p = prune products");
        System.out.println("x = exit");
    }
}
