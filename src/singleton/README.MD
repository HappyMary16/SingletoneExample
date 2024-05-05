### Структура створених обʼктів (з використанням патерну Одинак - Singleton)

    Головний клас                     Main
                                    /      \
    Сервіси              ParkingService   StatisticService
                                    \      /   
    Керування сховищем              ParkingDb
                                        |
    Сховище                      Map<String, Car>