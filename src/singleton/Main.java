package singleton;

import singleton.model.Car;
import singleton.service.ParkingService;
import singleton.service.StatisticService;

import java.time.Instant;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("З використанням патерну Одинак - Singleton");
        System.out.println("--------------------------");

        ParkingService parkingService = new ParkingService(10);
        StatisticService statisticService = new StatisticService();

        Car car = new Car("AA1111AA", Instant.now());
        System.out.println("Паркуємо автомобіль (в ParkingService): " + parkingService.parkCar(car));
        System.out.println("Припарковані автомобілі (з ParkingService): " + parkingService.getAllCars());
        System.out.println("Кількість автомобілів на парковці (з StatisticService): " + statisticService.getAmountOfCars());
    }
}