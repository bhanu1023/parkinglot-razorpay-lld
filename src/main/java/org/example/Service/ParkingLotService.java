package org.example.Service;

import org.example.Exception.SlotNotAvailableException;
import org.example.Strategy.HourlyCostingStartegy;
import org.example.Strategy.NaturalOrderingSlotStartegy;
import org.example.Strategy.SlotAssignmentStrategy;
import org.example.models.*;

import java.util.List;

public class ParkingLotService {
    public ParkingLot createParkingLot(){
        ParkingLot parkingLot = ParkingLot.getBuilder()
                .setName("Wave Parking")
                .setFloors(
                        List.of(
                                new Floor(1),
                                new Floor(2)
                        )
                )
                .setAddress("Gurgaon")
                .setSlotAssignmentStrategy(new NaturalOrderingSlotStartegy())
                .setPricingStartgey(new HourlyCostingStartegy())
                .build();

        return  parkingLot;

    }

    public Ticket parkVehicle(ParkingLot parkingLot, Vehicle vehicle) throws SlotNotAvailableException {
        AdminService adminService = new AdminService(parkingLot);
        Slot slot = adminService.AssignSlot(vehicle);
        Ticket ticket = adminService.generateTicket(vehicle, slot);
        return ticket;
    }



}
