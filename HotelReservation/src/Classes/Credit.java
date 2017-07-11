package Classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Credit extends Payment{
    private int cvv;
    private long cardNumber;
    private Date expDate;
    SimpleDateFormat expFormat = new SimpleDateFormat("MM/yyyy");
    
    public Credit(int total) {
        super(total);
    }

    @Override
    public void pay(int pay, Date paymentDate) {
        super.pay(pay, paymentDate);
        super.paymentMethod = getPaymentMethod();
    }
    
    public String getPaymentMethod() {
        paymentMethod = "Credit";
        return paymentMethod;
    }

    @Override
    public String toString() {
        String info = "";
        info += super.toString();
        info += "Card Number\t\t: " + cardNumber + "\n";
        info += "Exp Date\t\t: " + expFormat.format(expDate) + "\n";
        info += "CVV\t\t: " + cvv + "\n";
        
        return info;
    }
    

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Date getExpDate() {
        return expDate;
    }
}
