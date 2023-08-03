package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.Strategy.PricingStartegy;
import org.example.Strategy.SlotAssignmentStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ParkingLot {
    private int id;
    private String name;
    private String address;
    private List<Floor> floors;
    private List<Gate> gates;
    private Map<Vehicle, Slot> parkedVehicles;
    private Map<VehicleType, Integer> baseprice;
    private Map<VehicleType, Integer> vehicleCount;
    private SlotAssignmentStrategy slotAssignmentStrategy;

    private PricingStartegy pricingStartegy;

    private ParkingLot(ParkingLotBuilder builder){
        this.id = builder.getId();
        this.name = builder.getName();
        this.floors = builder.getFloors();
        this.gates = builder.getGates();
        this.slotAssignmentStrategy = builder.getSlotAssignmentStrategy();
        this.pricingStartegy = builder.getPricingStartegy();

        this.parkedVehicles = new HashMap<>();

        this.vehicleCount = new HashMap<>();
        this.vehicleCount.put(VehicleType.SCOOTER, 0);
        this.vehicleCount.put(VehicleType.SUPER_BIKE, 0);

        this.baseprice = new HashMap<>();
        this.baseprice.put(VehicleType.SCOOTER, 20);
        this.baseprice.put(VehicleType.SUPER_BIKE, 50);

    }

    public static ParkingLotBuilder getBuilder(){
        return new ParkingLotBuilder();
    }



    @Getter
    @Setter
    public static class ParkingLotBuilder{
        private int id;
        private String name;
        private String address;
        private List<Floor> floors;
        private List<Gate> gates;
        private SlotAssignmentStrategy slotAssignmentStrategy;
        private PricingStartegy pricingStartegy;

        public ParkingLot build(){
            return new ParkingLot(this);
        }

        public ParkingLotBuilder setFloors(List<Floor> floors) {
            this.floors = floors;
            return this;
        }

        public ParkingLotBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ParkingLotBuilder setAddress(String address){
            this.address = address;
            return this;
        }

        public ParkingLotBuilder setSlotAssignmentStrategy(SlotAssignmentStrategy slotAssignmentStrategy){
            this.slotAssignmentStrategy = slotAssignmentStrategy;
            return this;
        }

        public ParkingLotBuilder setPricingStartgey(PricingStartegy pricingStartegy){
            this.pricingStartegy = pricingStartegy;
            return this;
        }
    }
}
