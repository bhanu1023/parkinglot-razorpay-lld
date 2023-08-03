package org.example.Strategy;

import org.example.Exception.SlotNotAvailableException;
import org.example.models.*;

public interface SlotAssignmentStrategy {
    public Slot AssignSlot(ParkingLot parkingLot, Vehicle vehicle) throws SlotNotAvailableException;
}
