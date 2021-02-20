import java.text.*;
import javafx.beans.property.*;

public class CashRegister implements ProductObserver {
    private DoubleProperty cash = new SimpleDoubleProperty();

    public CashRegister() {
        this.cash.set(0.0);
    }
    
    public final double getCash() { 
        return cash.get(); 
    }
    
    public ReadOnlyDoubleProperty cashProperty() {
        return cash;
    }
    
    public void add(double money) {
        cash.set(cash.get() + money);
    }

    @Override
    public void handleSale(double amount) {
        add(amount);
    }
}
