import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaxiFleet myFleet = new TaxiFleet();

        myFleet.addCar(new EconomyCar("Daewoo Lanos", 3000, 8.5, 160));
        myFleet.addCar(new EconomyCar("Renault Logan", 6000, 7.0, 170));
        myFleet.addCar(new BusinessCar("Toyota Camry 3.5", 25000, 9.5, 210));
        myFleet.addCar(new BusinessCar("Mercedes E-Class", 45000, 10.2, 240));
        myFleet.addCar(new Minivan("Volkswagen Transporter", 18000, 8.8, 180));

        System.out.println("Весь таксопарк:");
        myFleet.printFleet();

        System.out.println("\nЗагальна вартість автопарку: $" + myFleet.TotalFleetValue());

        System.out.println("\nТаксопарк після сортування за витратою палива:");
        myFleet.FuelConsumption();
        myFleet.printFleet();

        int minSpeed = 165;
        int maxSpeed = 200;
        System.out.println("\nПошук авто зі швидкістю від " + minSpeed + " до " + maxSpeed + " км/год:");
        List<Car> suitableCars = myFleet.SpeedRange(minSpeed, maxSpeed);
        for (Car car : suitableCars) {
            System.out.println(car);
        }
    }
}
