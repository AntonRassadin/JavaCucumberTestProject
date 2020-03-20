@otlad
Feature: Тестирование open.ru
  Scenario: Переход на сайт open.ru из google и проверка курса валют
  Given запустить Chrome
  Then перейти на сайт 'https://www.google.com/'
  Then написать в строке поиска 'Открытие'
  Then нажать Поиск
  Then проверить, что результатах поиска есть 'https://www.open.ru/'
  Then перейти на сайт 'https://www.open.ru'
  Then проверить в блоке «Курс обмена в интернет-банке», что курс продажи больше курса покупки, для USD и для EUR.

