package org.example.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    private int id;
    private String vehicleNumber;
    private VehicleType vehicleType;

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
