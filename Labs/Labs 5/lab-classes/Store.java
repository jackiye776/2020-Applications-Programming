/**
* The store has and sells one product: Sticky tape.
*
* You can sell and restock a product, view stock and view cash.
*/
    public class Store {
    public static void main(String[] args){
        Store store = new Store();
        store.use();
    }
    // insert 2 fields here
    private Product product;
    private CashRegister cashRegister;
    // insert 1 constructor here
    public Store(){
        product = new Product("Sticky tape", 200, 2.99);
        cashRegister = new CashRegister(0);
    }
    
    public void use() { // MENU
        char choice;
        while((choice = readChoice()) != 'x') {
            switch(choice) {
                case 's' : sell(); break;
                case 'r' : restock(); break;
                case 'v' : viewStock(); break;
                case 'c' : viewCash(); break;
                default: help(); break;
            }
        }
    }
    
    private char readChoice(){
        System.out.print("Choice (s/r/v/c/x): ");
        return In.nextChar();
    }
    
    private void sell() {
        System.out.print("Number: ");
        int number = In.nextInt();
        double money = 0;
        if(product.has(number)){
            money = product.sell(number);
            cashRegister.add(money);
        } else {
            System.out.println("Not enough stock");
        }
    }
        
    private void restock() {
        System.out.print("Number: ");
        int number = In.nextInt();
        product.restock(number);
        }
    
    private void viewStock() {
        System.out.println(product);
    }
    
    private void viewCash() {
        System.out.println(cashRegister);
    }
            
    private void help() {
        System.out.println("Menu options");
        System.out.println("s = sell");
        System.out.println("r = restock");
        System.out.println("v = view stock");
        System.out.println("c = view cash");
        System.out.println("x = exit");
    }
}
