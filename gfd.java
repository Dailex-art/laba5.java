import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

abstract class Car {
    private String model;
    private int price;
    private double fuelConsumption;
    private int maxSpeed;

    public Car(String model, int price, double fuelConsumption, int maxSpeed) {
        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
    }

    public int getPrice() {
        return price; }
    public double getFuelConsumption() {
        return fuelConsumption;}
    public int getMaxSpeed() {
        return maxSpeed; }

    @Override
    public String toString() {
        return String.format("%s (Швидкість: %d км/год, Паливо: %.1f л/100км, Ціна: %d$)",
                model, maxSpeed, fuelConsumption, price);
    }
}

class EconomyCar extends Car {
    public EconomyCar(String model, int price, double fuelConsumption, int maxSpeed) {
        super(model, price, fuelConsumption, maxSpeed);
    }
}

class BusinessCar extends Car {
    public BusinessCar(String model, int price, double fuelConsumption, int maxSpeed) {
        super(model, price, fuelConsumption, maxSpeed);
    }
}

class Minivan extends Car {
    public Minivan(String model, int price, double fuelConsumption, int maxSpeed) {
        super(model, price, fuelConsumption, maxSpeed);
    }
}

class TaxiFleet {
    private List<Car> cars = new ArrayList<>();
    public void addCar(Car car) {
        cars.add(car);
    }

    public int TotalFleetValue() {
        int totalValue = 0;
        for (Car car : cars) {
            totalValue += car.getPrice();
        }
        return totalValue;
    }

    public void FuelConsumption() {
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return Double.compare(c1.getFuelConsumption(), c2.getFuelConsumption());
            }
        });
    }

    public List<Car> SpeedRange(int minSpeed, int maxSpeed) {
        List<Car> foundCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed) {
                foundCars.add(car);
            }
        }
        return foundCars;
    }

    public void printFleet() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
