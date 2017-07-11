package Classes;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer implements Serializable{
    private static AtomicInteger count = new AtomicInteger();
    private int customerId;
    private String name, address, noTlp;

    public Customer(String name, String address, String noTlp) {
        this.customerId = count.incrementAndGet();
        this.name = name;
        this.address = address;
        this.noTlp = noTlp;
    }
    
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNoTlp() {
        return noTlp;
    }

    public void setNoTlp(String noTlp) {
        this.noTlp = noTlp;
    }

    @Override
    public String toString() {
        String info = "";
        info += customerId + "-" + name;
        return info;
    }

    public static void setCount(AtomicInteger count) {
        Customer.count = count;
    }

    public static AtomicInteger getCount() {
        return count;
    }
}
