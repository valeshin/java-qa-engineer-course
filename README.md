# ДЗ #1: Автотест со своими ожиданиями
___

&nbsp;
### Настройка окружения: 
Для запуска тестов из командной строки необходимо:
1. Установить Java, желательно не ниже 11 версии
2. Установить Maven, если он у вас еще не установлен, это странно, вот инструкция https://maven.apache.org/install.html

&nbsp;
### Запуск тестов:
* `mvn clean test` - запустить все тесты
* `mvn clean test -Dbrowser=browsername` - запуск тестов на конкретном браузере поддержаны браузеры:
  - chrome (значение по умолчанию);
  - firefox;
  - opera;
* `mvn clean test -Dtest=TestClassName` - запуск конкретного тестового класса
* `mvn clean test -Dtest=TestClassName#testName` - запуск конкретного теста