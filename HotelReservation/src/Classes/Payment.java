package Classes;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment implements Serializable{   
    public int total, pay;
    public Date paymentDate;
    public String paymentMethod;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
    
    public Payment(int total) {
        this.total = total;
    }
    
    public void pay(int pay, Date paymentDate) {
        this.paymentDate = paymentDate;
        this.pay = pay;
        hitungTotal(pay);
    }

    public int getTotal() {
        return total;
    }
    
    public int hitungTotal(int bayar){
        this.total -= bayar;
        return this.total;
    }
    
    @Override
    public String toString() {
        String info = "";
        info += "Payment\t\t: " + pay + "\n";
        info += "Method of Payment\t: " + paymentMethod + "\n";
        info += "Date\t\t: " + dateFormat.format(paymentDate) + "\n";
        return info;
    }
}
