package org.example.Strategy;

import org.example.models.ParkingLot;
import org.example.models.Ticket;
import org.example.models.Vehicle;
import org.example.models.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class HourlyCostingStartegy implements PricingStartegy{
    @Override
    public double calculateCost(ParkingLot parkingLot, Ticket ticket) {
        Vehicle vehicle = ticket.getVehicle();
        LocalDateTime parkingInTime = ticket.getParkingInTime();
        LocalDateTime parkingOutTime = ticket.getGetParkingOutTime();

        VehicleType vehicleType = vehicle.getVehicleType();
        double hourlyCost = parkingLot.getBaseprice().get(vehicleType);

        long hours = ChronoUnit.HOURS.between(parkingInTime, parkingOutTime);

        return hourlyCost * hours;

    }
}
