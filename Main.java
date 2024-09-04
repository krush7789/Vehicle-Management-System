import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private String make;
    private String model;
    private int year;
    private double price;

    public Vehicle(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Make: " + make + ", Model: " + model + ", Year: " + year + ", Price: $" + price;
    }
}

public class VehicleManager {
    private List<Vehicle> vehicles;

    public VehicleManager() {
        vehicles = new ArrayList<Vehicle>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vehicle vehicle : vehicles) {
            sb.append(vehicle.toString()).append("\n");
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleManager vehicleManager = new VehicleManager();
        boolean running = true;

        while (running) {
            System.out.println("Vehicle Management System");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View Vehicles");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();

                    Vehicle newVehicle = new Vehicle(make, model, year, price);
                    vehicleManager.addVehicle(newVehicle);
                    System.out.println("Vehicle added successfully!");
                    break;
                case 2:
                    System.out.println("All Vehicles:");
                    System.out.println(vehicleManager.toString());
                    break;
                case 3:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}