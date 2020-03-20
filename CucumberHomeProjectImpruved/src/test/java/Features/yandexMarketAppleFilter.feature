@otlad
Feature: Тестирование https://market.yandex.ru/
  Scenario: Фильтрование по производителю Apple в мобильных телефонах
    Given запустить Chrome
    Then перейти на сайт 'https://market.yandex.ru/'
    Then перейти в раздел 'Мобильные телефоны'
    Then установить фильтр по производителю 'Apple'
    Then проверить что в полученной выборке только производитель 'Apple' на '10' страницах

