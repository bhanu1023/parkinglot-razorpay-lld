package org.example;

import org.example.Exception.SlotNotAvailableException;
import org.example.Service.AdminService;
import org.example.Service.ParkingLotService;
import org.example.models.*;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            ParkingLotService parkingLotService = new ParkingLotService();

            ParkingLot parkingLot = parkingLotService.createParkingLot();

            AdminService adminService = new AdminService(parkingLot);

            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleType(VehicleType.SCOOTER);
            vehicle.setVehicleNumber("MP123");

            Vehicle vehicle2 = new Vehicle();
            vehicle2.setVehicleType(VehicleType.SUPER_BIKE);
            vehicle2.setVehicleNumber("UP456");

            Ticket ticket = parkingLotService.parkVehicle(parkingLot, vehicle);
            Ticket ticket1 = parkingLotService.parkVehicle(parkingLot, vehicle2);

            adminService.removeVehicle(ticket);
            adminService.removeVehicle(ticket1);

            System.out.println(ticket);
            System.out.println(ticket1);

            System.out.println(adminService.getVehicleCount(VehicleType.SCOOTER));
            System.out.println(adminService.getVehicleCount(VehicleType.SUPER_BIKE));

            System.out.println(adminService.getParkingDetails(vehicle));
            System.out.println(adminService.getParkingDetails(vehicle2));
        }catch (SlotNotAvailableException slotNotAvailableException){
            System.out.println(slotNotAvailableException.getMessage());
        }


    }
}