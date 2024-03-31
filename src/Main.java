import model.Car;
import service.ParkingService;
import service.StatisticService;

import java.time.Instant;

public class Main {
    
    public static void main(String[] args) {
        ParkingService parkingService = ParkingService.getInstance(10);
        StatisticService statisticService = new StatisticService();

        Car car = new Car("AA1111AA", Instant.now());
        System.out.println("Машина припаркована: " + parkingService.parkCar(car));
        System.out.println("Кількість автомобілів на парковці: " + statisticService.getAmountOfCars());
    }
}