package com.yearup.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name, address, phone;
    private final List<Vehicle> vehicles;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = new ArrayList<>();
    }
    public Dealership () {
        vehicles = new ArrayList<>();
    }
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getAllVehicles () {
        return vehicles;
    }

    public List<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            double price = vehicle.getPrice();
            if (price >= minPrice && price <= maxPrice) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByYear(int year) {
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getYear() == year) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int maxMileage) {
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getOdometer() <= maxMileage) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByVin(String vin) {
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin().equalsIgnoreCase(vin)) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}