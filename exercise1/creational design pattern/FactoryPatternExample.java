// Product Interface
interface Vehicle {
    void drive();
}

// Concrete Products
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car.");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike.");
    }
}

// Factory Class
class VehicleFactory {
    public Vehicle getVehicle(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("Car")) {
            return new Car();
        } else if (vehicleType.equalsIgnoreCase("Bike")) {
            return new Bike();
        }
        throw new IllegalArgumentException("Invalid vehicle type");
    }
}

// Usage
public class FactoryPatternExample {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();

        Vehicle car = factory.getVehicle("Car");
        car.drive(); // Driving a car

        Vehicle bike = factory.getVehicle("Bike");
        bike.drive(); // Riding a bike
    }
}
