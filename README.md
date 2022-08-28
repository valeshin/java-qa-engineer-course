# ДЗ #1: Автотест со своими ожиданиями + ДЗ #4: Запуск тестов в Selenoid
___

&nbsp;
### Настройка окружения: 
Для запуска тестов из командной строки необходимо:
1. Установить Java, желательно не ниже 11 версии
2. Установить Maven, если он у вас еще не установлен, это странно, вот инструкция https://maven.apache.org/install.html

&nbsp;
### Запуск тестов:
По-умолчанию запуск настроен запуск тестов на удаленное машине/в докер-контейнере в 3 потока
* `mvn clean test` - запустить все тесты
* `mvn clean test -Dwebdriver.remote=false` - запустить все тесты локально
* `mvn clean test -Dthread.count=X` - запустить все тесты в X потоков
* `mvn clean test -Dbrowser=browsername` - запуск тестов на конкретном браузере поддержаны браузеры:
  - chrome (значение по умолчанию);
  - firefox;
  - opera;
* `mvn clean test -Dbrowser=browsername -Dbrowser.version=version` - запуск тестов на конкретной версии браузера
* `mvn clean test -Dtest=TestClassName` - запуск конкретного тестового класса
* `mvn clean test -Dtest=TestClassName#testName` - запуск конкретного теста