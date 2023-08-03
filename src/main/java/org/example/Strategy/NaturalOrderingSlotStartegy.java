package org.example.Strategy;

import org.example.Exception.SlotNotAvailableException;
import org.example.models.*;

import java.util.List;
import java.util.Map;

public class NaturalOrderingSlotStartegy implements SlotAssignmentStrategy {
    private ParkingLot parkingLot;

    private Slot findEmptySlot(ParkingLot parkingLot, Vehicle vehicle){
        List<Floor> floors = parkingLot.getFloors();

        for(int j=0;j<floors.size();j++){
            List<Slot> slots = floors.get(j).getSlots();

            Slot emptySlot = null;

            for(int i=0;i<slots.size();i++){
                Slot curSlot = slots.get(i);
                if(curSlot.getSlotStatus() == SlotStatus.AVAILABLE && curSlot.getVehicleType() == vehicle.getVehicleType()){
                    emptySlot = curSlot;
                    break;
                }
            }

            if(emptySlot == null){
                for(int i=0;i<slots.size();i++){
                    Slot curSlot = slots.get(i);
                    if(curSlot.getSlotStatus() == SlotStatus.AVAILABLE){
                        emptySlot = curSlot;
                        break;
                    }
                }
            }

            return emptySlot;

        }

        return null;
    }

    @Override
    public Slot AssignSlot(ParkingLot parkingLot, Vehicle vehicle) throws SlotNotAvailableException {

        Slot emptySlot = this.findEmptySlot(parkingLot, vehicle);

        if(emptySlot == null) throw new SlotNotAvailableException("Slot not availble");

        Map<Vehicle, Slot> parkedVehicles = parkingLot.getParkedVehicles();
        Map<VehicleType, Integer> vehicleCount = parkingLot.getVehicleCount();

        emptySlot.setVehicleParked(vehicle);
        emptySlot.setSlotStatus(SlotStatus.OCCUPIED);

        parkedVehicles.put(vehicle, emptySlot);
        vehicleCount.put(vehicle.getVehicleType(), 1 + vehicleCount.get(vehicle.getVehicleType()));

        return emptySlot;
    }
}
