package org.example.Strategy;

import org.example.models.ParkingLot;
import org.example.models.Ticket;

public interface PricingStartegy {
    public double calculateCost(ParkingLot parkingLot, Ticket ticket);
}
