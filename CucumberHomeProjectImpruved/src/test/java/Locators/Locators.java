package Locators;

import org.openqa.selenium.By;

public class Locators {
    static public By googleSearchInput = By.xpath("//input[@class='gLFyf gsfi'][@name='q']"); //googleSearchInput
    static public By googleSubmitSearchButton = By.xpath("//input[contains(@class, 'gNO89b')]");      //googleSubmitSearchButton

    static public By yandexSearchInput = By.xpath("//*[@id='text']");                             //yandexSearchInput
    static public By yandexSearchButton = By.xpath("//*[@class='search2__button']");          //yandexSearchButton

    static public By openRuExchangeTableRates = By.xpath("//span[@class='main-page-exchange__rate']"); //Значения с таблицы с курсами валют open.ru
}

