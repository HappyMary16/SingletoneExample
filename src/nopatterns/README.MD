### Структура створених обʼктів (без використання патернів)

    Головний клас                     Main
                                    /      \
    Сервіси              ParkingService  StatisticService
                                |               |
    Керування сховищем      ParkingDb       ParkingDb
                                |               |
    Сховище           Map<String, Car>       Map<String, Car>