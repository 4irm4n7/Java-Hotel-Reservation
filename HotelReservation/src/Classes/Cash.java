package Classes;

import java.util.Date;

public class Cash extends Payment{

    public Cash(int total) {
        super(total);
    }

    public String getPaymentMethod() {
        paymentMethod = "Cash";
        return paymentMethod;
    }
    
    @Override
    public void pay(int pay, Date paymentDate) {
        super.pay(pay, paymentDate);
        super.paymentMethod = getPaymentMethod();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
