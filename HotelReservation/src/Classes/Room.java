package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Room implements GetRoomFare, Serializable{
    
    private static AtomicInteger count = new AtomicInteger();
    private int roomId, bedNumber;
    private String roomNo;
    private boolean hasWifi, hasBreakFast;
    private RoomFare roomClass;
    private ArrayList<Booking> arrayBooking = new ArrayList<>();

    public Room(int bedNumber, String roomNo, boolean hasWifi, boolean hasBreakFast) {
        this.roomId = count.incrementAndGet();
        this.bedNumber = bedNumber;
        this.roomNo = roomNo;
        this.hasWifi = hasWifi;
        this.hasBreakFast = hasBreakFast;
    }

    @Override
    public String toString() {
        String info = "";
        info += "Room ID" + "\t: "  + getRoomId() + "\n";
        info += "Room Number\t: " + getRoomNo()+ "\n";
        info += "Type\t: " + roomClass.getRoomType()+ "\n";
        info += "Beds\t: " + getBedNumber()+ "\n";
        info += "Wifi\t: " + isHasWifi()+ "\n";
        info += "Breakfast\t: " + isHasBreakFast()+ "\n";
        info += "price/day\t: " + roomClass.getHargaPerHari() + "\n";
        return info;
    }

    @Override
    public void getRoomFare(RoomFare roomFare) {
        this.roomClass = roomFare;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public boolean isHasBreakFast() {
        return hasBreakFast;
    }

    public void setHasBreakFast(boolean hasBreakFast) {
        this.hasBreakFast = hasBreakFast;
    }

    public RoomFare getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(RoomFare roomClass) {
        this.roomClass = roomClass;
    }

    public ArrayList<Booking> getArrayBooking() {
        return arrayBooking;
    }

    public static void setCount(AtomicInteger count) {
        Room.count = count;
    }

    public static AtomicInteger getCount() {
        return count;
    }
}
