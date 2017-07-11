package Classes;

import java.io.Serializable;

public class RoomFare implements Serializable{
    private int payPerDay;
    private String roomType;

    public RoomFare(int payPerDay, String roomType) {
        this.payPerDay = payPerDay;
        this.roomType = roomType;
    }

    public int getHargaPerHari() {
        return payPerDay;
    }

    public void setHargaPerHari(int payPerDay) {
        this.payPerDay = payPerDay;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return this.roomType;
    }
}
