package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Floor {
    private int floor;
    private List<Slot> slots;
    private final static int MAX_SLOT_PER_TYPE = 1;

    public Floor(int floor){
        this.floor = floor;
        this.slots = new ArrayList<>();

        for(VehicleType type: VehicleType.values()){
            for(int i=0;i<MAX_SLOT_PER_TYPE;i++){
                Slot slot = new Slot();
                slot.setSlotStatus(SlotStatus.AVAILABLE);
                slot.setVehicleType(type);
                this.slots.add(slot);
            }
        }

    }
}
