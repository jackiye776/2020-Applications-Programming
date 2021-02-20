import java.text.*;

/**
* The cash register stores cash.
*
* You can add cash to the cash register.
*/
public class CashRegister {
    private double cash;

    public CashRegister(int cash) {
        this.cash = cash;
    }
    // insert 1 method here
    public double add(double money){
        cash += money;
        return cash;
    }

    /**
     * Return a string in the form:
     *
     * Cash register: $[cash]
     *
     * e.g. "Cash register: $29.90"
     *
     * If there is no cash, instead return:
     *
     * "Cash register: empty"
     */
    @Override
    public String toString() {
        if(cash >= 1){
            return "Cash: $" + formatted(cash);
        } else {
            return "Cash register: empty";
        }
    }
    
    private String formatted(double value) {
        DecimalFormat f = new DecimalFormat("###,##0.00");
        return f.format(value);
    }
}
