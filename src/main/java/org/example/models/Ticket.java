package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Ticket {
    private int id;
    private String ticketid;
    private Vehicle vehicle;
    private Slot slot;
    private LocalDateTime parkingInTime;
    private LocalDateTime getParkingOutTime;
    private TicketStatus ticketStatus;
    private double totalCost;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticketid='" + ticketid + '\'' +
                ", vehicle=" + vehicle +
                ", slot=" + slot +
                ", parkingInTime=" + parkingInTime +
                ", getParkingOutTime=" + getParkingOutTime +
                ", ticketStatus=" + ticketStatus +
                ", totalCost=" + totalCost +
                '}';
    }
}
