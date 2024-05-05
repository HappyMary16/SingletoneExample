package singleton.db;

import singleton.model.Car;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Реалізація "in memory" бази даних в якій зберігаються автомобілі.
 *
 * @author mariia.borodin (mborodin)
 * @since 1.1
 */
public class ParkingDb {

    /**
     * Зберігає в собі створений обʼєкт класу ParkingDb і повертає його
     * під час виклику методу getInstance().
     */
    private static volatile ParkingDb instance;
    private final Map<String, Car> cars;

    private ParkingDb() {
        cars = new HashMap<>();
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
     * @return створений або вже існуючий обʼєкт цього класу
     */
    public static synchronized ParkingDb getInstance() {
        if (instance == null) {
            instance = new ParkingDb();
        }

        return instance;
    }

    /**
     * Метод який створює обʼєкт класу, гарантуючи що буде
     * створений тільки один обʼєкт для всієї програми.
     * Тобто цей клас реалізує патерн Singleton.
     * <p>
     * Конструктор має модифікатор доступу private для того,
     * щоб ніде крім цього методу не можна було створити ще один обʼєкт цього класу.
     *
     * @return - створений або вже існуючий обʼєкт цього класу
     */
    public static ParkingDb getInstanceBetterImplementation() {
        // наступні 3 рядки забезпечують ефективнішу роботу методу,
        // який гарантує створення одного екземпляру цього класу
        if (instance == null) {
            synchronized (ParkingDb.class) {
                if (instance == null) {
                    instance = new ParkingDb();
                }
            }
        }

        return instance;
    }

    public void addCar(Car car) {
        cars.put(car.getCarNumber(), car);
    }

    public void removeCar(String carNumber) {
        cars.remove(carNumber);
    }

    public Collection<Car> getAllCars() {
        return cars.values();
    }

    public Car getCar(String carNumber) {
        return cars.get(carNumber);
    }

    public int getAmountOfCars() {
        return cars.size();
    }
}
