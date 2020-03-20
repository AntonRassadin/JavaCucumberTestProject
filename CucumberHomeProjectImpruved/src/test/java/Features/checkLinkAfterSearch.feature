@otlad
Feature: Поиск в яндексе
  Scenario: Поиск ссылки в результатах поиска
    Given запустить Chrome
    Then перейти на сайт 'https://yandex.ru/'
    Then ввести в поиск 'Гладиолус'
    Then нажать поиск
    Then найти в результатах ссылку 'https://ru.wikipedia.org/wiki/%D0%A8%D0%BF%D0%B0%D0%B6%D0%BD%D0%B8%D0%BA'

