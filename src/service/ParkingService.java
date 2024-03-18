package service;

import db.ParkingDb;
import model.Car;

/**
 * Відповідальний за всі дії, які можуть відбуватися на парковці:
 * <pre>
 * - паркування автомобілів
 * - видалення автомобілів з парковки
 * </pre>
 */
public class ParkingService {

    private static volatile ParkingService instance;

    private final ParkingDb parkingDb;
    private final int parkingSize;

    /**
     * Конструктор класу.
     *
     * @param parkingSize розмір парковки
     */
    private ParkingService(int parkingSize) {
        //TODO: Розкоментуй рядок 27 і закоментуй рядок 28
//        this.parkingDb = new ParkingDb();
        this.parkingDb = ParkingDb.newInstance();
        this.parkingSize = parkingSize;
    }

    /**
     * Метод який створює обʼєкт класу, гарантуючи що буде
     * створений тільки один обʼєкт для всієї програми.
     * Тобто цей клас реалізує патерн Singleton.
     * <p>
     * Конструктор має модифікатор доступу private для того,
     * щоб ніде крім цього методу не можна було створити ще один обʼєкт цього класу.
     * <p>
     * Ключове слово synchronized гарантує, що метод виконуватиметься одночасно в одному потоці.
     *
     * @param parkingSize розмір парковки з яким буде створено обʼєкт, якщо обʼєкт класу ще не створений
     * @return створений або вже існуючий обʼєкт цього класу
     */
    public static synchronized ParkingService newInstance(int parkingSize) {
        if (instance == null) {
            instance = new ParkingService(parkingSize);
        }

        return instance;
    }

    /**
     * Додає автомобіль на парковку, якщо ще є вільне місце.
     *
     * @param car автомобіль, який треба припаркувати
     * @return true - якщо автомобіль вдалося припаркувати,
     * false - якщо на парковці не було місця для автомобіля
     */
    public boolean parkCar(Car car) {
        if (parkingDb.getAmountOfCars() == parkingSize) {
            return false;
        }

        parkingDb.addCar(car);
        return true;
    }

    /**
     * Видаляє автомобіль з парковки.
     *
     * @param carNumber номер автомобіля, який потрібно видалити
     */
    public void removeCar(String carNumber) {
       parkingDb.removeCar(carNumber);
    }
}
