package Classes;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Booking implements GetRoomFare, Serializable{
    private static AtomicInteger count = new AtomicInteger();
    DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
    private Customer customer;
    private int bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private Payment payment;
    private int fare;
    private ArrayList<Payment> arrayPayment = new ArrayList<>();

    public Booking(Customer customer, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.bookingId = count.getAndIncrement();
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public ArrayList<Payment> getArrayPayment() {
        return arrayPayment;
    }

    @Override
    public void getRoomFare(RoomFare roomFare) {
        long jumlahHari = checkOutDate.getTime() - checkInDate.getTime();
        fare = (int) (roomFare.getHargaPerHari() * TimeUnit.DAYS.convert(jumlahHari, TimeUnit.MILLISECONDS));
        this.payment = new Payment(fare);
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }
    

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getTarip() {
        return fare;
    }

    public void setTarip(int tarip) {
        this.fare = tarip;
    }

    public static void setCount(AtomicInteger count) {
        Booking.count = count;
    }

    public static AtomicInteger getCount() {
        return count;
    }
}
