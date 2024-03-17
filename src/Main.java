import db.ParkingDb;
import model.Car;
import service.ParkingService;
import service.StatisticService;

import java.time.Instant;

public class Main {
    
    public static void main(String[] args) {
        ParkingService parkingService = ParkingService.newInstance(10);

        //TODO: Розкоментуй рядок 13 і закоментуй рядок 14
//        StatisticService statisticService = new StatisticService(new ParkingDb());
        StatisticService statisticService = new StatisticService(ParkingDb.newInstance());


        Car car = new Car("AA1111AA", Instant.now());
        System.out.println("Машина припаркована: " + parkingService.parkCar(car));
        System.out.println("Кількість автомобілів на парковці: " + statisticService.getAmountOfCars());
    }
}