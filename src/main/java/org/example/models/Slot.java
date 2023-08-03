package org.example.models;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Slot {
    private int id;
    private SlotStatus slotStatus;
    private Vehicle vehicleParked;
    private VehicleType vehicleType;

    @Override
    public String toString() {
        return "Slot{" +
                "id=" + id +
                ", slotStatus=" + slotStatus +
                ", vehicleParked=" + vehicleParked +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
