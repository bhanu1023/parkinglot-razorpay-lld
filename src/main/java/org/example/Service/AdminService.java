package org.example.Service;

import org.example.Exception.SlotNotAvailableException;
import org.example.Strategy.HourlyCostingStartegy;
import org.example.Strategy.SlotAssignmentStrategy;
import org.example.models.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class AdminService {
    private ParkingLot parkingLot;

    public AdminService(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public int getVehicleCount(VehicleType vehicleType){
        return parkingLot.getVehicleCount().get(vehicleType);
    }

    public Slot getParkingDetails(Vehicle vehicle){
        return parkingLot.getParkedVehicles().get(vehicle);
    }

    public Slot AssignSlot(Vehicle vehicle) throws SlotNotAvailableException {
        SlotAssignmentStrategy slotAssignmentStrategy = parkingLot.getSlotAssignmentStrategy();
        return slotAssignmentStrategy.AssignSlot(parkingLot, vehicle);
    }

    public Ticket generateTicket(Vehicle vehicle, Slot slot){
        Ticket ticket = new Ticket();
        ticket.setTicketid("T123");
        ticket.setVehicle(vehicle);
        ticket.setSlot(slot);
        ticket.setTicketStatus(TicketStatus.IN_PROGRESS);
        ticket.setParkingInTime(LocalDateTime.of(LocalDate.of(2023, Month.AUGUST, 3), LocalTime.of(10, 38, 9)));
        return ticket;
    }

    public Ticket removeVehicle(Ticket ticket){
        ticket.setGetParkingOutTime(LocalDateTime.now());
        ticket.setTicketStatus(TicketStatus.SUCCESS);
        ticket.setTotalCost(parkingLot.getPricingStartegy().calculateCost(parkingLot, ticket));

        return ticket;
    }
}
