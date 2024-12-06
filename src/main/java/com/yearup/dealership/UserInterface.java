package com.yearup.dealership;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public Dealership dealership;
    public static Scanner scan = new Scanner(System.in);
    private List<Vehicle> vehicles;

    private void init() {
        dealership = DealershipFileManager.getDealership();

    }

    public void display() {
        init();


        while (true) {
            displayMenu();
            String userOptions = scan.nextLine();

            switch (userOptions) {

                case "1":
                    viewAllVehicles();
                    break;
                case "2":
                    searchCriteria();
                    break;
                case "3":
                    boolean buyOption = true;
                    while (buyOption) {
                        saleOrLease();
                        String buyInput = scan.nextLine();
                        switch (buyInput) {
                            case "1":
                                int vinInput;
                                System.out.println("Congratulations on deciding to purchase a new car!\n"+"Enter the Vin of the car you want to Buy:");
                                vinInput = scan.nextInt();
                                ContractFileManager manager = new ContractFileManager();
                                Vehicle userVehicle = new Vehicle("409011",2014,"Ford","Avenger","Sedan","Black",67000,4500);
                                Contract contract1 = new SalesContract("11/3/2024","Jane Doe","Janedoe@gmail.com",userVehicle,4500,0,295,100,295,false);
                                manager.saveContract(contract1);
                                break;
                            case "2":
                                System.out.println("Congratulations on deciding to Lease a car!\n'['");
                                break;
                            case "3":
                                System.out.println("Returning to previous menu.");
                                buyOption = false;
                        }
                    }

                    break;
                case "4":
                    System.out.println("Thank you for choosing TK Auto. We hope to see you soon! Goodbye.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option chosen, try again");
            }

        }

    }

    private void saleOrLease() {
        System.out.println("""
                Choose an option:
                1.Sell Vehicle
                2.Lease Vehicle
                3.Return to Main Menu""");

    }

    public void processAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            displayVehicles(vehicles); // Display each vehicle using the helper method
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

    }

    public void viewAllVehicles() {
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    public void processGetByPriceRequest() {
        System.out.println("Enter minimum price:");
        double minPrice = scan.nextDouble();
        System.out.println("Enter maximum price:");
        double maxPrice = scan.nextDouble();
        scan.nextLine(); // Consume newline

        List<Vehicle> vehiclesByPrice = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehiclesByPrice);
    }

    public void processGetByMakeModelRequest() {
        System.out.println("Enter vehicle make:");
        String make = scan.nextLine();
        System.out.println("Enter vehicle model:");
        String model = scan.nextLine();

        List<Vehicle> vehiclesByMakeModel = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehiclesByMakeModel);
    }

    public void processGetByYearRequest() {
        System.out.println("Enter the year of the vehicle:");
        int year = scan.nextInt();
        scan.nextLine(); // Consume newline

        List<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(year);
        displayVehicles(vehiclesByYear);
    }

    public void processGetByColorRequest() {
        System.out.println("Enter the color of the vehicle:");
        String color = scan.nextLine();

        List<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(color);
        displayVehicles(vehiclesByColor);
    }

    public void processGetByMileageRequest() {
        System.out.println("Enter maximum mileage:");
        int maxMileage = scan.nextInt();
        scan.nextLine(); // Consume newline

        List<Vehicle> vehiclesByMileage = dealership.getVehiclesByMileage(maxMileage);
        displayVehicles(vehiclesByMileage);
    }

    public void processGetByVehicleTypeRequest() {
        System.out.println("Enter the type of vehicle (e.g., Sedan, SUV, etc.):");
        String vehicleType = scan.nextLine();

        List<Vehicle> vehiclesByType = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehiclesByType);
    }

    public void processGetAllVehicleRequest() {
        List<Vehicle> allVehicles= dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    public void processAddVehicleRequest() {
        System.out.println("Enter the VIN number:");
        String vin = scan.nextLine();
        System.out.println("Enter the year:");
        int year = scan.nextInt();
        scan.nextLine(); // Consume newline
        System.out.println("Enter the make:");
        String make = scan.nextLine();
        System.out.println("Enter the model:");
        String model = scan.nextLine();
        System.out.println("Enter the type (e.g., Sedan, SUV):");
        String vehicleType = scan.nextLine();
        System.out.println("Enter the color:");
        String color = scan.nextLine();
        System.out.println("Enter the odometer reading:");
        int odometer = scan.nextInt();
        System.out.println("Enter the price:");
        double price = scan.nextDouble();
        scan.nextLine(); // Consume newline

        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(newVehicle);
        System.out.println("Vehicle added successfully!");

    }

    public void processRemoveVehicleRequest() {
        System.out.println("Please enter the Vin of the vehicle you would like to remove: ");
        String vehicleVin = scan.nextLine();
        boolean vehicleMatch = false;

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicleVin == vehicle.getVin()) {
                vehicleMatch = true;
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle has been removed!");
                DealershipFileManager.saveDealership(dealership);
                break;
            }
        }

    }

    private void searchCriteria() {
        System.out.println("""
                1.Search by Price
                2.Search by Make/Model
                3.Search by Year
                4.Search by Color
                5.Search by Mileage
                6.Search by Vehicle Type\n""");
        int searchOption = scan.nextInt();
        switch (searchOption) {
            case 1 -> processGetByPriceRequest();
            case 2 -> processGetByMakeModelRequest();
            case 3 -> processGetByYearRequest();
            case 4 -> processGetByColorRequest();
            case 5 -> processGetByMileageRequest();
            case 6 -> processGetByVehicleTypeRequest();

        }


    }

    public void displayMenu() {
        System.out.println("""
                Welcome to TK Auto!
                1.View All Vehicles
                2.Search by Criteria:
                3.Sell/Lease
                4.Exit""");

    }
}